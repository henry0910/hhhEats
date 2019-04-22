package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Courier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourierRepository extends CrudRepository<Courier, Long> {
    List<Courier> findAll();

}
