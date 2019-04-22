package com.ascending.hhhEats.domain;


import javax.persistence.*;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

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

    public Long getId() {
        return id;
    }

    public List<Order> getOrders() {
        return this.orders;
    }
}
