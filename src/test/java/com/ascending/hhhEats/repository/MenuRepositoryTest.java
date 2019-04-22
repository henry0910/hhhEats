package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Menu;
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
public class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Menu m = new Menu();
        m.setGenre("Asian");
        menuRepository.save(m);
        Optional<Menu> testMenu = menuRepository.findById(m.getId());
        assertNotNull(testMenu);
        assertEquals(m.getId(), testMenu.get().getId());
    }
}
