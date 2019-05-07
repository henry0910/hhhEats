package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Dish;
import com.ascending.hhhEats.service.DishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("Unit")
public class DishServiceTest {
    @Autowired
    private DishService dishService;

    @Test
    @Transactional
    public void findByIdTest() {
        Dish d = new Dish();
        d.setName("huiguorou");
        d.setGenre("Chuan cai");
        dishService.save(d);
        Optional<Dish> testDish = dishService.findById(d.getId());
        assertNotNull(testDish);
        assertEquals(d.getId(), testDish.get().getId());

    }


}
