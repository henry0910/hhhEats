package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Category;
import com.ascending.hhhEats.service.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    Optional<Category> findById(Long Id);

}
