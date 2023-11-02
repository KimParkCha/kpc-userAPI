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

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/user/register")
    public ResponseEntity<User> register(@RequestBody User user){
        Long userId = userService.join(user);
        if(userService.findOne(userId).equals(user)){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else{
            return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
