package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Courier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourierRepository extends CrudRepository<Courier, Long> {
    @Query(value = "SELECT c FROM couriers")
    List<Courier> findAll();

    @Query(value = "SELECT x FROM couriers c WHERE c.Id = ?1")
    Optional<Courier> findById(Long Id);

}
