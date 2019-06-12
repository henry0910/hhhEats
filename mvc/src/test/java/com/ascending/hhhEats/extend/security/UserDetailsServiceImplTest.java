package com.ascending.hhhEats.extend.security;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void loadUserByUsernameTest() {
        User u = new User();
        u.setUsername("shentianjie");
        userService.save(u);
        UserDetails testUser = userDetailsService.loadUserByUsername("shentianjie");
        assertNotNull(testUser);
    }
}