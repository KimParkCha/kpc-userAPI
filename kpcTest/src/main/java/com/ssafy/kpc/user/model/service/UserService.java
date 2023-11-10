package com.ssafy.kpc.user.model.service;

import com.ssafy.kpc.user.model.entity.User;
import com.ssafy.kpc.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void join(User user){
        validateDuplicateMember(user);
        userRepository.save(user);
    }

    private void validateDuplicateMember(User user) {
        List<User> findUsers = userRepository.findByName(user.getName());
        if(!findUsers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId){
        return userRepository.findById(userId);
    }

    public Optional<User> login(String email, String password) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }
}
