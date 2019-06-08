package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Order;
import com.ascending.hhhEats.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService extends CrudService<Order, Long>{
    @Autowired
    private OrderRepository orderRepository;


    @Override
    protected CrudRepository<Order, Long> getCurdRepository() {
        return this.orderRepository;
    }

    public List<Order> findByAmountGreaterThan(BigDecimal amount) {
        List<Order> res = this.orderRepository.findByAmountGreaterThan(amount);
        return res;
    }

}
