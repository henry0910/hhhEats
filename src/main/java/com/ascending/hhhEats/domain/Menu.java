package com.ascending.hhhEats.domain;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Menus")
public class Menu {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="menus_id_seq")
    @SequenceGenerator(name="menus_id_seq", sequenceName="menus_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "genre")
    private String genre;

}
