package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationsDTO extends BaseDTO{
    private String status;
    private Long user_id;
    List<ReservedSeatsDTO> reservedSeats = new ArrayList<>();
    public ReservationsDTO() {
    }

    public ReservationsDTO(Long id, Date createdDate, Date modifiedDate, String status, Long user_id) {
        super(id,createdDate,modifiedDate);
        this.status = status;
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<ReservedSeatsDTO> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeatsDTO> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
