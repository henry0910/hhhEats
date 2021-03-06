package com.ascending.hhhEats.service;


import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.extend.exp.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.net.URL;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void findByIdTest() {
        User u = new User("tjshen");
        u.setEmail("tianjie.shen@rhsmith.umd.edu");
        userService.save(u);
        Optional<User> testUser = userService.findById(u.getId());
        assertNotNull(testUser);
        assertEquals(u.getId(), testUser.get().getId());
    }

    @Test
    @Transactional
    public void findByUsernameTest() throws NotFoundException {
        User u = new User("tjshen");
        userService.save(u);
        URL url = Mockito.mock(URL.class);
        Optional<User> testUser = userService.findByUsername(u.getUsername());
        assertEquals(u.getUsername(), testUser.get().getUsername());
    }

}
