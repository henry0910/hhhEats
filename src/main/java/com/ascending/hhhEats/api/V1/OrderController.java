package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Order;
import com.ascending.hhhEats.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public class OrderController {
    @Autowired
    private OrderService orderService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getCourierList() {
        return orderService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public Optional<Order> getCourierById(@PathVariable("Id") Long Id) {
        return orderService.findById(Id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order createNewOrder(@RequestBody Order order) {
        orderService.save(order);
        return order;
    }
}
