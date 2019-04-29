package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Order;
import com.ascending.hhhEats.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class OrderService extends CrudService<Order, Long>{
    @Autowired
    private OrderRepository orderRepository;


    @Override
    protected CrudRepository<Order, Long> getCurdRepository() {
        return this.orderRepository;
    }

}
