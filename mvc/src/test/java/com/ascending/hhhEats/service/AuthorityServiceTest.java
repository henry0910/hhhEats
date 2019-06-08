package com.ascending.hhhEats.service;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Authority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("Unit")
public class AuthorityServiceTest {
    @Autowired
    private AuthorityService authorityService;

    @Test
    @Transactional
    public void findByIdTest() {
        Authority a = new Authority();
        a.setAuthority("admin");
        authorityService.save(a);
        Optional<Authority> testAuth = authorityService.findById(a.getId());
        assertNotNull(testAuth);
        assertEquals(a.getId(), testAuth.get().getId());

    }
}
