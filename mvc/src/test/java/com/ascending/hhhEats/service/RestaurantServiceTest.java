package com.ascending.hhhEats.service;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Restaurant;
import com.ascending.hhhEats.service.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class RestaurantServiceTest {
    @Autowired
    private RestaurantService restaurantService;

    @Test
    @Transactional
    public void findByIdTest() {
        Restaurant r = new Restaurant();
        r.setName("Asian Pot");
        r.setTelephoneNumber("3458263894");
        restaurantService.save(r);
        Optional<Restaurant> testRestaurant = restaurantService.findById(r.getId());
        assertNotNull(testRestaurant);
    }
}
