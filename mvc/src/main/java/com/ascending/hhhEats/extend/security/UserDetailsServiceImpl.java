package com.ascending.hhhEats.extend.security;

import com.ascending.hhhEats.domain.Authority;
import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.extend.exp.NotFoundException;
import com.ascending.hhhEats.service.AuthorityService;
import com.ascending.hhhEats.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.debug("This is load user by username.");
        try {
            User domainUser = userService.findByUsername(s).get();
            return setUserAuthority(domainUser);
        }
        catch (NotFoundException ex) {
            return null;
        }

    }

    private UserDetails setUserAuthority(User user) {
        List<Authority> authorities = authorityService.findAuthorityByUser(user);
        user.setAuthorities(authorities);
        return user;
    }
}
