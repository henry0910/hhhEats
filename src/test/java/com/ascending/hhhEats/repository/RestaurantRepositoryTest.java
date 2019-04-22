package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Restaurant;
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
@ActiveProfiles("Unit")
public class RestaurantRepositoryTest {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Restaurant r = new Restaurant();
        r.setName("Asian Pot");
        r.setTelephoneNumber("3458263894");
        restaurantRepository.save(r);
        Optional<Restaurant> testRestaurant = restaurantRepository.findById(r.getId());
        assertNotNull(testRestaurant);
    }
}
