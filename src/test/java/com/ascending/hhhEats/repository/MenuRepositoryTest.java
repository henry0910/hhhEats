package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Menu;
import com.ascending.hhhEats.service.MenuService;
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
    private MenuService menuService;

    @Test
    @Transactional
    public void findByIdTest() {
        Menu m = new Menu();
        m.setGenre("Asian");
        menuService.save(m);
        Optional<Menu> testMenu = menuService.findById(m.getId());
        assertNotNull(testMenu);
        assertEquals(m.getId(), testMenu.get().getId());
    }
}
