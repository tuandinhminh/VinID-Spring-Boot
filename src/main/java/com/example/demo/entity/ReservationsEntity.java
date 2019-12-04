package com.example.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservations")
public class ReservationsEntity extends BaseEntity{
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity user;

    @OneToMany(mappedBy = "reservation")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ReservedSeatsEntity> reservedSeats = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public List<ReservedSeatsEntity> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeatsEntity> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
