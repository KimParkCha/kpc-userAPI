package com.ssafy.kpc.user.model.service;

import com.ssafy.kpc.user.model.entity.Salt;
import com.ssafy.kpc.user.model.entity.User;
import com.ssafy.kpc.user.model.repository.SaltRepository;
import com.ssafy.kpc.user.model.repository.UserRepository;
import com.ssafy.kpc.user.util.SaltUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final SaltRepository saltRepository;

    private final SaltUtil saltUtil;

    @Transactional
    public void registUser(User user){
        String password = user.getPassword();
        String salt = saltUtil.genSalt();
        log.info(salt);
        user.setSalt(new Salt(salt));
        user.setPassword(saltUtil.encodePassword(salt,password));
        validateDuplicateMember(user);
        userRepository.save(user);
    }

    private void validateDuplicateMember(User user) {
        List<User> findUsers = userRepository.findByName(user.getName());
        if(!findUsers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public User loginUser(String email, String password) throws Exception{
        User user = userRepository.findByEmail(email);
        if(user==null) throw new Exception ("멤버가 조회되지 않음");
        String salt = user.getSalt().getSalt();
        System.out.println("salt = " + salt);
        password = saltUtil.encodePassword(salt,password);
        System.out.println("password : " + password);
        System.out.println("저장된 passoword" + user.getPassword());
        if(!user.getPassword().equals(password)){
            throw new Exception ("비밀번호가 틀립니다.");
        }
        System.out.println("user.getId() = " + user.getId());
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getEmail() = " + user.getEmail());
        System.out.println("user.getPassword() = " + user.getPassword());
        System.out.println("user.getAddress() = " + user.getAddress());
        return user;
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId){
        return userRepository.findById(userId);
    }

    public User getUserEmail(String email){
        return userRepository.findByEmail(email);
    }

}
