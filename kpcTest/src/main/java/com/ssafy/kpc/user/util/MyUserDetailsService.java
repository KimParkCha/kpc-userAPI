package com.ssafy.kpc.user.util;


import com.ssafy.kpc.user.model.entity.SecurityUser;
import com.ssafy.kpc.user.model.entity.User;
import com.ssafy.kpc.user.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        List<User> user = userRepository.findByName(userEmail);
        if(user.isEmpty()){
            throw new UsernameNotFoundException(userEmail + " : 사용자 존재하지 않음");
        }

        return new SecurityUser(user.get(0));
    }
}