package com.example.springsecurity02.config;

import com.example.springsecurity02.model.Users;
import com.example.springsecurity02.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/7/24 0:12
 **/
@Component
public class LoginDetailService implements UserDetailsService {

    @Autowired
    private UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users = usersService.findByUsername(s);
        return User.withUsername(s).password(users.getPassword()).authorities("p1").build();
    }

}
