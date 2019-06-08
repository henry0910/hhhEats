package com.ascending.hhhEats.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;
import org.postgis.Geometry;
import org.postgis.Point;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Users")
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    private Long id;

    @Column(unique=true)
    private String username;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="password")
    private String password;

    @Column(name="telephone_number")
    private String telephoneNumber;

    @Column(name="email_address")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "street")
    private String street;

    @Column(name = "account_non_expired")
    private boolean AccountNonExpired;

    @Column(name = "account_non_locked")
    private boolean AccountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean CredentialsNonExpired;

    @Column(name = "enabled")
    private boolean Enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Authority> authorities;

//    @JsonIgnore
//    @Type(type = "org.hibernate.spatial.GeometryType")
//    private Point location;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Order> orders;

    public User() { }

    public User(String username){
        this.username=username;
//        this.email=email;
    }


    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<Authority> authorities) {this.authorities=authorities;}

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    public String getUsername() {return this.username;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

//    public void setAuthorities(String auth) {
//        Authority a = new Authority();
//        a.setAuthority(auth);
//        a.setUser(this);
//        this.authorities.add(a);
//    }

//    public Point getLocation() {
//        return location;
//    }
//
//    public void setLocation(Point location) {
//        this.location = location;
//    }
    //    public List<Order> getOrders() {
//        return this.orders;
//    }
}
