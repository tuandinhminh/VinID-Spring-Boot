package com.example.demo.dto;

import java.util.Date;

public class ReservedSeatsDTO extends BaseDTO{
    private Long seat_id;
    private Long reservation_id;
    private Long screening_id;
    private Long type_id;

    public ReservedSeatsDTO() {
    }

    public ReservedSeatsDTO(Long id, Date createdDate, Date modifiedDate,Long seat_id,
                            Long reservation_id, Long screening_id, Long type_id) {
        super(id,createdDate,modifiedDate);
        this.seat_id = seat_id;
        this.reservation_id = reservation_id;
        this.screening_id = screening_id;
        this.type_id = type_id;
    }

    public ReservedSeatsDTO(Long id, Date createdDate, Date modifiedDate) {
        super(id, createdDate, modifiedDate);
    }

    public Long getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Long seat_id) {
        this.seat_id = seat_id;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Long getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(Long screening_id) {
        this.screening_id = screening_id;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }
}
