package com.ascending.hhhEats.extend.security;

import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void loadUserByUsernameTest() {
//        User u = new User();
//        u.setUsername("shentianjie");
//        userService.save(u);
//        UserDetails testUser = userDetailsService.loadUserByUsername("shentianjie");
//        assertNotNull(testUser);
    }
}