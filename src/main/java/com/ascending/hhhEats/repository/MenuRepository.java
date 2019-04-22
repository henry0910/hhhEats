package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, Long> {
//    @Query(value = "SELECT c FROM menus")
    List<Menu> findAll();

//    @Query(value = "SELECT c FROM Menu m WHERE m.Id = ?1")
//    Optional<Menu> findById(Long Id);



}
