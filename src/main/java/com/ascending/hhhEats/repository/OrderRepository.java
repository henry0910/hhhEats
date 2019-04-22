package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query(value = "SELECT c FROM orders")
    List<Order> findAll();

    @Query(value = "SELECT c FROM orders o WHERE o.Id = ?1")
    Optional<Order> findById(Long Id);
}
