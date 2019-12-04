package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScreeningsDTO extends BaseDTO {
    private int amount;
    private long auditorium_id;
    private String start_time;
    private String start_date;
    private long movie_id;
    List<ReservedSeatsDTO> reservedSeats = new ArrayList<>();
    public ScreeningsDTO() {
    }

    public ScreeningsDTO(Long id, Date createdDate, Date modifiedDate, int amount,
                         long auditorium_id, String start_time, String start_date, long movie_id) {
        super(id, createdDate, modifiedDate);
        this.amount = amount;
        this.auditorium_id = auditorium_id;
        this.start_time = start_time;
        this.start_date = start_date;
        this.movie_id = movie_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getAuditorium_id() {
        return auditorium_id;
    }

    public void setAuditorium_id(long auditorium_id) {
        this.auditorium_id = auditorium_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public List<ReservedSeatsDTO> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeatsDTO> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
