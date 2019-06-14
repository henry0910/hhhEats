package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Authority;
import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.extend.exp.NotFoundException;
import com.ascending.hhhEats.repository.UserRepository;
import com.ascending.hhhEats.service.jms.MessageService;
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

    @Autowired
    private MessageService messageService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    protected CrudRepository<User, Long> getCurdRepository() {
        return this.userRepository;
    }

    public Optional<User> findByUsername(String username) throws NotFoundException {
        if (username == null || username.length() == 0) throw new NotFoundException();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.get() == null) throw new NotFoundException();
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