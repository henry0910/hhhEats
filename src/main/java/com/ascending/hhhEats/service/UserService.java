package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends CrudService<User,Long> {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    protected CrudRepository<User, Long> getCurdRepository() {
        return this.userRepository;
    }



    public Optional<User> findByUsernameIgnoreCase(String username) {
        Optional<User> user = userRepository.findByUsernameIgnoreCase(username);
        return user;
    }
}