package com.ascending.hhhEats.domain;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="courier")
public class Courier {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    private Long id;

    @Column(name="courier_name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="vehicle")
    private String vehicle;

    @Column(name="telephone_number")
    private String telephoneNumber;

}
