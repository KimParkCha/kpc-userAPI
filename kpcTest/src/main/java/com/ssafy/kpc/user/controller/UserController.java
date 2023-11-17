package com.ssafy.kpc.user.controller;

import com.ssafy.kpc.user.model.dto.Response;
import com.ssafy.kpc.user.model.dto.UserDto;
import com.ssafy.kpc.user.model.entity.User;
import com.ssafy.kpc.user.model.service.UserService;
import com.ssafy.kpc.user.model.service.UserServiceImpl;
import com.ssafy.kpc.user.util.CookieUtil;
import com.ssafy.kpc.user.util.JwtUtil;
import com.ssafy.kpc.user.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    private final JwtUtil jwtUtil;

    private final CookieUtil cookieUtil;

    private final RedisUtil redisUtil;
//    @GetMapping("/")
//    public ResponseEntity Hello (@RequestBody User user){
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping(value = "/register")
    public Response register(@RequestBody User user){
        try {
            System.out.println("register Controller 실행");
            userService.registUser(user);
            return new Response(user,"success", "회원가입을 성공적으로 완료했습니다.", null, null);
        } catch (Exception e) {
            return new Response(null,"error", "회원가입을 하는 도중 오류가 발생했습니다.", null, null);
        }
    }

    @PostMapping(value = "/login")
    public Response login(@RequestBody User userDto, HttpServletRequest req, HttpServletResponse res){
        try {
            System.out.println("loginUserController");
            User user = userService.loginUser(userDto.getEmail(), userDto.getPassword());
            System.out.println("1 = " + 1);
            final String token = jwtUtil.generateToken(user);
            System.out.println("2 = " + 2);
            final String refreshJwt = jwtUtil.generateRefreshToken(user);
            System.out.println("3 = " + 3);
            System.out.println("refreshJwt = " + refreshJwt);
            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);

            System.out.println("accessToken = " + accessToken.getValue());
            System.out.println("refreshToken = " + refreshToken.getValue());
//            redisUtil.setDataExpire(refreshJwt, user.getName(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            res.addCookie(accessToken);
            res.addCookie(refreshToken);
//            return new ResponseEntity<MemberDto>("success", "로그인에 성공했습니다.", token);
            return new Response(user, "success", "로그인에 성공했습니다.", accessToken.getValue(), refreshToken.getValue());
        } catch (Exception e) {
            return new Response(null,"error", "로그인 정보가 맞지 않습니다!", e.getMessage(), null);
        }
    }

    @GetMapping(value = "/detailUser/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {

        if(userService.getUserEmail(email) != null){
            return new ResponseEntity<User>(userService.getUserEmail(email), HttpStatus.OK);
        } else{
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/logout")
    public Response logout(HttpServletRequest request){
        System.out.println("로그아웃");
        return new Response(null, "success", "로그아웃 성공", null, null);
    }


}
