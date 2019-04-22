package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    @Query(value = "SELECT * FROM restaurants", nativeQuery = true)
    List<Restaurant> findAll();

    @Query(value = "SELECT c FROM restaurants r where r.id = ?1")
    Optional<Restaurant> findById(Long Id);

    @Query(value = "SELECT c FROM restaurants r where r.city = ?1")
    List<Restaurant> findByCity(String city);

}
