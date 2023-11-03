package com.ssafy.kpc.model.service;

import com.ssafy.kpc.model.dto.User;
import java.util.List;
import java.util.Optional;


public interface UserService {

    // 회원가입
    public Long join(User user);

    public List<User> findUsers();

    public User findOne(Long userId);

    Optional<User> login(String email, String password);
}
