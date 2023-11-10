package com.ssafy.kpc.user.model.repository;

import com.ssafy.kpc.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    public User findOne(Long id);

//    public User findOneEmail(String email) {return em.find(User.class, email);}
    public Optional<User> findById(Long id);

    public List<User> findAll();

    public List<User> findByName(String name);

    public Optional<User> findByEmail(String email);

}
