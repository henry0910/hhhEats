package com.ascending.hhhEats.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Authorities")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="authorities_id_seq")
    @SequenceGenerator(name = "authorities_id_seq", sequenceName="authorities_id_seq", allocationSize=1)
    private Long Id;

    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Authority() {}

    public Authority(User user, String name) {
        this.user=user;
        this.name=name;
    }

    @Override
    public String getAuthority() { return this.name; }

    public void setAuthority(String name) {this.name=name;}

    public User getUser() {return this.user;}

}
