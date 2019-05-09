package com.ascending.hhhEats.domain;


import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="dishes_id_seq")
    @SequenceGenerator(name="dishes_id_seq", sequenceName="dishes_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public Dish() {}

    public Dish(String genre, String name, BigDecimal price) {
        this.genre=genre;
        this.name=name;
        this.price=price;
    }

    public void setName(String name) {this.name=name;}

    public void setGenre(String genre) {this.genre=genre;}

    public void setPrice(BigDecimal price) {this.price=price;}

    public String getName() {return this.name;}

    public String getGenre() {return this.genre;}

    public BigDecimal getPrice() {return this.price;}

    public Long getId() {return this.id;}

}
