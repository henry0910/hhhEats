package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Courier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CourierRepository extends CrudRepository<Courier, Long> {
//    @Query(value = "SELECT c FROM couriers")
    List<Courier> findAll();

//    @Query(value = "SELECT x FROM couriers c WHERE c.Id = ?1")
//    Optional<Courier> findById(Long Id);
//
//    @Query(value = "SELECT x FROM couriers c where c.gender = ?1")
//    Set<Courier> findByGender(String gender);
//
//    @Query(value = "SELECT x FROM couriers c WHERE c.gender = ?1 and c.vehicle = ?2")
//    Collection<Courier> findByGenderAndVehicle(String gender, String vehicle);

}
