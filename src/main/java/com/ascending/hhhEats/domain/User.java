package com.ascending.hhhEats.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    private Long id;

    @Column(unique=true)
    private String username;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="password")
    private String password;

    @Column(name="telephone_number")
    private String telephoneNumber;

    @Column(name="email_address")
    private String email;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Order> orders;

    public User() {}

    public User(String username){
        this.username=username;
//        this.email=email;
    }

    public void setUsername(String user_name) {
        username = user_name;
    }

    public void setEmail(String email_address) {
        email = email_address;
    }

    public void setFirstName(String first_Name) {firstName = first_Name;}

    public void setLastName(String last_Name) {lastName = last_Name;}

    public void setPassword(String pass_word) {password = pass_word;}

    public void setTelephoneNumber(String telephone) {telephoneNumber = telephone;}

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public String getUsername() {return this.username;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getTelephoneNumber() {return this.telephoneNumber;}

    public String getEmail() {return this.email;}

//    public List<Order> getOrders() {
//        return this.orders;
//    }
}
