package com.example.demo.form;

import com.example.demo.dto.SeatsDTO;

import java.util.ArrayList;
import java.util.List;

public class ResponseSeats {
    private Long screening_id;
    List<SeatsDTO> seats = new ArrayList<>();

    public ResponseSeats() {
    }

    public ResponseSeats(Long screening_id) {
        this.screening_id = screening_id;
    }

    public ResponseSeats(Long screening_id, List<SeatsDTO> seats) {
        this.screening_id = screening_id;
        this.seats = seats;
    }

    public Long getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(Long screening_id) {
        this.screening_id = screening_id;
    }

    public List<SeatsDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatsDTO> seats) {
        this.seats = seats;
    }
}
