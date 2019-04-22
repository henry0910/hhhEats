package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
//    @Query(value = "SELECT c FROM restaurants")
    List<Restaurant> findAll();

    Optional<Restaurant> findById(Long Id);
//    @Query(value = "SELECT c FROM restaurants r where r.city = ?1")
//    List<Restaurant> findByCity(String city);
//
//    @Query(value = "SELECT c FROM restaurants r WHERE r.level = ?1")
//    List<Restaurant> findByLevel(String level);
//
//    @Query(value = "SELECT c FROM restaurants r WHERE r.genre = ?1")
//    List<Restaurant> findByGenre(String genre);

}
