package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Order;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAll();


}
