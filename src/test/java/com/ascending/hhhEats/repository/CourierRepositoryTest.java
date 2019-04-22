package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Courier;
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
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("Unit")
public class CourierRepositoryTest {
    @Autowired
    private CourierRepository courierRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Courier c = new Courier("tjshen", "123454");
        c.setGender("Male");
        c.setVehicle("Honda");
        courierRepository.save(c);
        Optional<Courier> testCourier = courierRepository.findById(c.getId());
        assertNotNull(testCourier);
        assertEquals(c.getId(), testCourier.get().getId());

    }

}
