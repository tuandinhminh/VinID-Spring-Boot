package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "seats")
public class SeatsEntity extends BaseEntity {
    @Column
    private int seatRow;
    @Column
    private int seatNumber;
    @OneToMany(mappedBy = "seat")
    private List<ReservedSeatsEntity> reservedSeats = new ArrayList<>();

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public List<ReservedSeatsEntity> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeatsEntity> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
