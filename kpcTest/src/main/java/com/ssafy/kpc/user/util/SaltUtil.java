package com.ssafy.kpc.user.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class SaltUtil {

    public String encodePassword(String salt, String password){
        return BCrypt.hashpw(password,salt);
    }

    // 난수 생성
    public String genSalt(){
        return BCrypt.gensalt();
    }

}
