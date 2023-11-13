package com.ssafy.kpc.user.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SecurityUser extends User {

    private static final long serialVersionUiD = 1L;

    public SecurityUser(com.ssafy.kpc.user.model.entity.User user){
        super(user.getEmail(),"{noop}"+ user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
    }


}
