package com.ascending.hhhEats.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="orders_id_seq")
    @SequenceGenerator(name="orders_id_seq", sequenceName="orders_id_seq", allocationSize=1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Dish> dishes;

    public List<Dish> getDishes() {
        return this.dishes;
    }

    public Order() {}

    public Order(BigDecimal amount, User user) {
        this.amount=amount;
        this.user=user;
    }

    public void setAmount(BigDecimal amount) {this.amount=amount;}

    public void setUser(User user) {this.user=user;}

    public void setRestaurant(Restaurant restaurant) {this.restaurant=restaurant;}

    public void setCourier(Courier courier) {this.courier=courier;}

    public Long getId() {return this.id;}

    public BigDecimal getAmount() {return this.amount;}

    public User getUser() {return this.user;}

    public Restaurant getRestaurant() {return this.restaurant;}

    public Courier getCourier() {return this.courier;}
}
