package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Order;
import com.ascending.hhhEats.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query(value = "SELECT c FROM orders")
    List<Order> findAll();

    @Query(value = "SELECT c FROM orders o WHERE o.Id = ?1")
    Optional<Order> findById(Long Id);

    @Query(value = "SELECT c FROM orders o WHERE o.amount >= ?1")
    List<Order> findByAmount(BigDecimal amount);

}
