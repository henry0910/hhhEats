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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Restaurant() {this.name="default";}

    public Restaurant(String name, String genre, String level, String address, String telephoneNumber, Category category) {
        this.name=name;
        this.genre=genre;
        this.level=level;
        this.address=address;
        this.telephoneNumber=telephoneNumber;
        this.category=category;
    }

    public void setName(String Name) {
        name = Name;
    }

    public void setTelephoneNumber(String telephone_Number) {
        telephoneNumber = telephone_Number;
    }

    public Long getId() {
        return this.id;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
