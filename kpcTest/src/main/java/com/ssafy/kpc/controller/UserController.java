package com.ssafy.kpc.controller;

import com.ssafy.kpc.model.dto.User;
import com.ssafy.kpc.model.service.UserService;
import com.ssafy.kpc.model.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/user/register")
    public ResponseEntity<User> register(@RequestBody User user){
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
//        user.setEmail(email);
        Long userId = userService.join(user);
        if(userService.findOne(userId).equals(user)){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else{
            return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @PostMapping(value = "/user/logout")
    public ResponseEntity<Void> logout(HttpSession session){
        System.out.println("로그아웃");
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
