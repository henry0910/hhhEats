package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Dish;
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
public class DishRepositoryTest {
    @Autowired
    private DishRepository dishRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Dish d = new Dish();
        d.setName("huiguorou");
        d.setGenre("Chuan cai");
        dishRepository.save(d);
        Optional<Dish> testDish = dishRepository.findById(d.getId());
        assertNotNull(testDish);
        assertEquals(d.getId(), testDish.get().getId());

    }


}
