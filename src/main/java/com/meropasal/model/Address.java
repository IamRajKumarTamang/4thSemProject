package com.meropasal.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String district;
    private String location;
//   @ManyToOne
//    private User users;

//    public User getUsers() {
//        return users;
//    }
//
//    public void setUsers(User users) {
//        this.users = users;
//    }
}
