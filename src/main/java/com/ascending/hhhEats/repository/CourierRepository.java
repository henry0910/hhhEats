package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Courier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.util.List;

public interface CourierRepository extends CrudRepository<Courier, Long> {
    List<Courier> findAll();

    List<Courier> findDistinctByGenderEqualsAndVehicle(String gender, String vehicle);
    List<Courier> findAllById(Long id);
    List<Courier> findCourierByName(String name);
}
