package com.example.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "screenings")
public class ScreeningsEntity extends BaseEntity {
    @Column
    private int amount;
    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    private AuditoriumsEntity auditorium;
    @Column
    private Date startTime;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MoviesEntity movie;
    @OneToMany(mappedBy = "screening")
    private List<ReservedSeatsEntity> reservedSeats = new ArrayList<>();
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public AuditoriumsEntity getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(AuditoriumsEntity auditorium) {
        this.auditorium = auditorium;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public MoviesEntity getMovie() {
        return movie;
    }

    public void setMovie(MoviesEntity movie) {
        this.movie = movie;
    }

    public List<ReservedSeatsEntity> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeatsEntity> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
