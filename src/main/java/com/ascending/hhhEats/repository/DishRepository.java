package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Long> {
    @Query(value = "SELECT c FROM Dishes")
    List<Dish> findAll();

    @Query(value = "SELECT c FROM Dishes d where d.Id = ?1")
    Optional<Dish> findById(Long Id);

    @Query(value = "SELECT c FROM Dishes d where d.genre = ?1")
    List<Dish> findByGenre(String genre);

    @Query(value = "SELECT c FROM Dishes d where d.price >= ?1")
    List<Dish> findByPrice(BigDecimal price);

    @Query(value = "SELECT c FROM Dishes d where d.name = ?1")
    List<Dish> findByName(String name);
}
