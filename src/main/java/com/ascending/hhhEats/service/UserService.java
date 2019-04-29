package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        logger.info("total number of array is: " + userRepository.findAll().size());
        if (userRepository.findAll().size() > 1) return userRepository.findAll();
        return new ArrayList<>();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(Long Id) {
        Optional<User> user = userRepository.findById(Id);
        return user;
    }

    public Optional<User> findByUsernameIgnoreCase(String username) {
        Optional<User> user = userRepository.findByUsernameIgnoreCase(username);
        return user;
    }
}