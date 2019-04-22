package com.ascending.hhhEats.domain;


import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="restaurants_id_seq")
    @SequenceGenerator(name="restaurants_id_seq", sequenceName="restaurants_id_seq", allocationSize=1)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="genre")
    private String genre;

    @Column(name="level")
    private String level;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="zip_code")
    private String zip_code;

    @Column(name="telephone_number")
    private String telephoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Order> orders;
}
