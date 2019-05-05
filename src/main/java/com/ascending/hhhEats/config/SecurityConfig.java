package com.ascending.hhhEats.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user")
                .password("{noop}password").roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/api/users/login","/api/user/login","/api/users/signup").permitAll()
                .and()
                .authorizeRequests().antMatchers("/api/**").hasAnyRole("REGISTERED_USER","ADMIN", "USER")
                .and().formLogin();
//                    .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);
    }
}
