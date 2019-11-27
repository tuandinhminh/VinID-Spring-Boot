package com.example.demo.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class UsersEntity extends BaseEntity {
    @Column(name = "username")
    private String userName;

    @Column
    private String password;

    @Column(unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy = "user")
    private List<ReservationsEntity> reservations = new ArrayList<>();
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservationsEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationsEntity> reservations) {
        this.reservations = reservations;
    }
}
