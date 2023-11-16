package com.ssafy.kpc.user.model.service;

import com.ssafy.kpc.user.model.entity.User;

import java.util.Optional;

public interface UserService {

    void registUser(User user);

    User loginUser(String email, String password) throws Exception;
    public User getUserEmail(String email);
}

