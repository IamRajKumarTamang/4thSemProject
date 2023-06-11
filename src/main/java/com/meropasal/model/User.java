package com.meropasal.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Where;


import javax.persistence.*;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    @Column(unique = true)
    private String username;
    @NonNull
    private String password;
    @NonNull
    @Column(unique = true)
    private long contactNum;
    @NonNull
    @Transient
    private String confirmPass;
//    @NonNull
//    @ManyToOne
//    private Address address;

    private boolean isDeleted = Boolean.FALSE;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contactNum=" + contactNum +
                ", confirmPass='" + confirmPass + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

