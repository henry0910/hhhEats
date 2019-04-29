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

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courier", cascade = CascadeType.ALL)
//    private List<Order> orders;

    public Courier() {}

    public Courier(String courierName, String telephone_Number) {
        this.name = courierName;
        this.telephoneNumber = telephone_Number;
    }

    public void setName(String name) {this.name=name;}

    public void setGender(String gender) {this.gender=gender;}

    public void setVehicle(String vehicle) {this.vehicle=vehicle;}

    public void setTelephoneNumber(String telephoneNumber) {this.telephoneNumber=telephoneNumber;}

    public Long getId() {return this.id;}

    public String getName() {return this.name;}

    public String getGender() {return this.gender;}

    public String getVehicle() {return this.vehicle; }

    public String getTelephoneNumber() {return this.telephoneNumber;}

//    public List<Order> getOrders() {
//        return this.orders;
//    }

}
