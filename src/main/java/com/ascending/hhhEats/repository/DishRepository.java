package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishRepository extends CrudRepository<Dish, Long> {
    List<Dish> findAll();
}
