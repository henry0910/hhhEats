package com.ascending.hhhEats.extend.security;

import com.ascending.hhhEats.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class JwtTokenUtilTest {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    @Transactional
    public void generateTokenTest() {

    }

    @Test
    @Transactional
    public void getUsernameFromTokenTest() {

    }

    @Test
    @Transactional
    public void isTokenExpiredTest() {

    }
}