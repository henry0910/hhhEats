package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    List<Menu> findAll();

}
