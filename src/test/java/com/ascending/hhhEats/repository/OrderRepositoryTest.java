package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Order;
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
    private OrderRepository orderRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Order o = new Order();
        orderRepository.save(o);
        Optional<Order> testOrder = orderRepository.findById(o.getId());
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
        orderRepository.save(o);
        orderRepository.save(o1);
        List<Order> testOrder = orderRepository.findByAmountGreaterThan(o.getAmount());
        assertNotNull(testOrder);
        assertEquals(1, testOrder.size());
    }
}
