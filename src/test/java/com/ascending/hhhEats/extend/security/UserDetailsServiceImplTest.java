package com.ascending.hhhEats.extend.security;

import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;

public class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void loadUserByUsernameTest() {
//        User u1 = userService.createUser(new User("shentianjie"));
//        UserDetails u2 = userDetailsService.loadUserByUsername("shentianjie");
//        assertEquals(u1.getUsername(), u2.getUsername());
    }
}