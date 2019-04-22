package com.ascending.hhhEats.domain;


import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Couriers")
public class Courier {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="couriers_id_seq")
    @SequenceGenerator(name="couriers_id_seq", sequenceName="couriers_id_seq", allocationSize=1)
    private Long id;

    @Column(name="courier_name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="vehicle")
    private String vehicle;

    @Column(name="telephone_number")
    private String telephoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courier", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Courier() {
        this.name = "admin";
        this.gender = "Male";
        this.vehicle = "Honda";
        this.telephoneNumber = "1234567890";
    }

    public List<Order> getOrders() {
        return this.orders;
    }

}
