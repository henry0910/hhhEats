package com.ascending.hhhEats.repository;

import com.ascending.hhhEats.domain.User;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
//    @Query(value = "SELECT c FROM users")
    List<User> findAll();

//    @Query(value = "SELECT u FROM users u WHERE u.Id = ?1")
//    Optional<User> findById(Long Id);
    Optional<User> findById(Long Id);
//    @Query(value = "SELECT c FROM users u WHERE u.email_address = ?1")
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameIgnoreCase(String username);

//    @Query(value = "SELECT u FROM User u join fetch u.orders")
//    List<User> findAllWithOrders();

//    @Query(value = "SELECT c FROM users u WHERE u.username = ?1")
//    List<User> findByUsername(String username);
//
//    @Query(value = "SELECT c FROM users u WHERE u.first_name = ?1")
//    Set<User> findByFirstName(String firstName);
//
//    @Query(value = "SELECT c FROM users u WHERE u.last_name = ?1")
//    Collection<User> findByLastName(String lastName);
}
