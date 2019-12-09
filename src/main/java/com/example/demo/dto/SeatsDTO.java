package com.example.demo.dto;

import java.util.Date;

public class SeatsDTO {
    private long id;
    private int seat_number;
    private String seat_row;
    private int status;

    public SeatsDTO() {
    }

    public SeatsDTO(long id, int seat_number, String seat_row, int status) {
        this.id = id;
        this.seat_number = seat_number;
        this.seat_row = seat_row;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public String getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(String seat_row) {
        this.seat_row = seat_row;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
