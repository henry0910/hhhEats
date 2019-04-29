package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Restaurant;
import com.ascending.hhhEats.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class RestaurantService extends CrudService<Restaurant, Long>{
    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    protected CrudRepository<Restaurant, Long> getCurdRepository() {
        return this.restaurantRepository;
    }

}
