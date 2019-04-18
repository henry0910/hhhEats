package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByUsername(String username);
    List<User> findUsersByEmail(String email);
    List<User> findUsersByUsernameOrderByFirstName(String username);
}
