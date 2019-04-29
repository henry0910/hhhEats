package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Dish;
import com.ascending.hhhEats.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class DishService extends CrudService<Dish, Long> {
    @Autowired
    private DishRepository dishRepository;

    @Override
    protected CrudRepository<Dish, Long> getCurdRepository() {
        return this.dishRepository;
    }
}
