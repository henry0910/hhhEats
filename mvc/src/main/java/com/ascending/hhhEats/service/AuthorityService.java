package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Authority;
import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService extends CrudService<Authority, Long> {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    protected CrudRepository<Authority, Long> getCurdRepository() {
        return this.authorityRepository;
    }

    public List<Authority> findAuthorityByUser(User user) {
        return this.authorityRepository.findByUser(user.getId());
    }

}
