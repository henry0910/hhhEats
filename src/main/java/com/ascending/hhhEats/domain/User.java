package com.ascending.hhhEats.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Users")
public class User {
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

    public String getUsername() {return this.username;}

    public String getTelephoneNumber() {return this.telephoneNumber;}

    public String getEmail() {return this.email;}

//    public List<Order> getOrders() {
//        return this.orders;
//    }
}
