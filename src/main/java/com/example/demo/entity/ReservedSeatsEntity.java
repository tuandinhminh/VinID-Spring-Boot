package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserved_seats")
public class ReservedSeatsEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatsEntity seat;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private ReservationsEntity reservation;
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private ScreeningsEntity screening;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private SeatTypesEntity seatType;

    public SeatsEntity getSeat() {
        return seat;
    }

    public void setSeat(SeatsEntity seat) {
        this.seat = seat;
    }

    public ReservationsEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationsEntity reservation) {
        this.reservation = reservation;
    }

    public ScreeningsEntity getScreening() {
        return screening;
    }

    public void setScreening(ScreeningsEntity screening) {
        this.screening = screening;
    }

    public SeatTypesEntity getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatTypesEntity seatType) {
        this.seatType = seatType;
    }
}
