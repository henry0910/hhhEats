package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Restaurant;
import com.ascending.hhhEats.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService extends CrudService<Restaurant, Long>{
    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    protected CrudRepository<Restaurant, Long> getCurdRepository() {
        return this.restaurantRepository;
    }

    public List<Restaurant> findByCategory(Long category_id) {
        return restaurantRepository.findByCategory(category_id);
    }

    public List<Restaurant> findByCity(String city) {
        return this.restaurantRepository.findByCity(city);
    }

    public List<Restaurant> findByZipCode(String zipcode) {
        return this.restaurantRepository.findByZip_code(zipcode);
    }

}
