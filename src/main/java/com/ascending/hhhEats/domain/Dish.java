package com.ascending.hhhEats.domain;


import javax.persistence.*;

import java.math.BigDecimal;

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



}
