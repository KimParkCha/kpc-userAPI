package com.ssafy.kpc.user.controller;

import com.ssafy.kpc.user.model.entity.User;
import com.ssafy.kpc.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @GetMapping("/")
//    public ResponseEntity Hello (@RequestBody User user){
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping(value = "/user/register")
    public ResponseEntity<User> register(@RequestBody User user){
        System.out.println("register Controller 실행");
        userService.join(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/user/login")
    public ResponseEntity<User> login(@RequestBody User user, HttpSession session){
        Optional<User> loginUser = userService.login(user.getEmail(), user.getPassword());

        if(loginUser.isPresent() && loginUser.get().getPassword().equals(user.getPassword())){
            session.setAttribute("userInfo", loginUser.get());
            System.out.println("유저 이름 :" +loginUser.get().getName());
            return new ResponseEntity<User>(loginUser.get(), HttpStatus.OK);
        } else{
            System.out.println("로그인 실패");
            return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/user/detailUser/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable int user_id) {
        Long id = Long.valueOf(user_id);
        if(userService.getUser(id).isPresent()){
            return new ResponseEntity<User>(userService.getUser(id).get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/user/logout")
    public ResponseEntity<Void> logout(HttpSession session){
        System.out.println("로그아웃");
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
