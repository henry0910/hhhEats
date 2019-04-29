package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Order;
import com.ascending.hhhEats.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("Unit")
public class OrderRepositoryTest {
    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    public void findByIdTest() {
        Order o = new Order();
        orderService.save(o);
        Optional<Order> testOrder = orderService.findById(o.getId());
        assertNotNull(testOrder);
        assertEquals(o.getId(), testOrder.get().getId());
    }

    @Test
    @Transactional
    public void findByAmountGreaterThan() {
        Order o = new Order();
        Order o1 = new Order();
        o.setAmount(BigDecimal.valueOf(64.34));
        o1.setAmount(BigDecimal.valueOf(67));
        orderService.save(o);
        orderService.save(o1);
        List<Order> testOrder = orderService.findByAmountGreaterThan(o.getAmount());
        assertNotNull(testOrder);
        assertEquals(1, testOrder.size());
    }
}
