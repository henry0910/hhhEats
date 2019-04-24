package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
//    @Query(value = "SELECT o FROM Order")
    List<Order> findAll();

    Optional<Order> findById(Long id);

//    @Query(value = "SELECT o FROM Order o WHERE o.amount >= ?1")
    List<Order> findByAmountGreaterThan(BigDecimal amount);

}
