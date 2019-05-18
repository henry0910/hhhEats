package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Authority;
import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService extends CrudService<User,Long> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    protected CrudRepository<User, Long> getCurdRepository() {
        return this.userRepository;
    }

    public Optional<User> findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }

    @Transactional
    public User createUser(User newUser) {
        String encodedPass = encoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPass);
        Authority a = new Authority();
        this.save(newUser);
        a.setAuthority("ROLE_REGISTERED_USER");
        a.setUser(newUser);
        authorityService.save(a);
//        newUser.setAuthorities("Registered_user");
        return newUser;
    }

}