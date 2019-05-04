package com.ascending.hhhEats.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="categories_id_seq")
    @SequenceGenerator(name = "categories_id_seq", sequenceName="categories_id_seq", allocationSize=1)
    private Long Id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;
}
