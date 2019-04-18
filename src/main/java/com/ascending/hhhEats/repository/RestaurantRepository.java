package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAllByGenreOrderByLevel(String genre);
    List<Restaurant> findAllByCityAndName(String name, String city);
    List<Restaurant> findDistinctByLevel(String level);
}
