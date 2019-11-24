package com.example.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "seat_types")
public class SeatTypesEntity extends BaseEntity {
    @Column
    private int type;
    @OneToMany(mappedBy = "seatType")
    private List<ReservedSeatsEntity> reservedSeats = new ArrayList<>();
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ReservedSeatsEntity> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeatsEntity> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
