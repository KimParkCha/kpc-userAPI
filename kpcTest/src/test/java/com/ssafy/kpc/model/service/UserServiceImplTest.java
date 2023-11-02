package com.ssafy.kpc.model.service;

import com.ssafy.kpc.model.dto.User;
import com.ssafy.kpc.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception{
        User user = new User();
        user.setName("kim");

        Long saveId = userService.join(user);

        em.flush();
        assertEquals(user, userRepository.findOne(saveId));
    }

    @Test
    public void 중복회원예외() throws Exception{
        User user1 = new User();
        user1.setName("kim");
        User user2 = new User();
        user2.setName("kim");

        userService.join(user1);

        try {
            userService.join(user2);
        } catch (IllegalStateException e){
            return;
        }
        fail("예외가 발생해야 한다.");
    }


}