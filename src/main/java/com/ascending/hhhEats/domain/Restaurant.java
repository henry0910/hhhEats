package com.ascending.hhhEats.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private List<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
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
        this.name = Name;
    }

    public void setTelephoneNumber(String telephone_Number) {
        telephoneNumber = telephone_Number;
    }

    public void setGenre(String genre) {this.genre=genre;}

    public void setLevel(String level) {this.level=level;}

    public void setAddress(String address) {this.address=address;}

    public void setCity(String city) {this.city=city;}

    public void setState(String state) {this.state=state;}

    public void setZip_code(String zip_code) {this.zip_code=zip_code;}

    public Long getId() {
        return this.id;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public String getName() {return this.name;}

    public String getGenre() {return this.genre;}

    public String getLevel() {return this.level;}

    public String getAddress() {return this.address;}

    public String getCity() {return this.city;}

    public String getState() {return this.state;}

    public String getZip_code() {return this.zip_code;}

    public String getTelephoneNumber() {return this.telephoneNumber;}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
