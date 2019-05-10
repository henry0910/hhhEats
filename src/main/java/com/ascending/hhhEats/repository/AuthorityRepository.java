package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.Authority;
import com.ascending.hhhEats.service.CrudService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    List<Authority> findAll();

    @Query("select a from Authority a where a.Id=?1")
    List<Authority> findByUser(Long user_id);
}
