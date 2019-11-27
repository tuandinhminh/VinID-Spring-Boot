package com.example.demo.controller;

import com.example.demo.dto.ReservationsDTO;
import com.example.demo.entity.ReservationsEntity;
import com.example.demo.entity.UsersEntity;
import com.example.demo.service.ReservationsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationsController {
    @Autowired
    private ReservationsService reservationsService;

    @ApiOperation(value = "Lấy danh sách Reservation")
    @GetMapping(value = "/reservations")
    public List<ReservationsDTO> getReservations(){
        return  reservationsService.getReservations();
    }

    @ApiOperation(value = "Lấy thông tin Reservation theo id")
    @GetMapping(value = "/reservations/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable("id") Long id) {
        return reservationsService.getReservationById(id);
    }

    @ApiOperation(value = "thêm mới Reservation")
    @PostMapping(value = "/reservations")
    public ReservationsDTO createReservation(@RequestBody ReservationsDTO model) {
        return reservationsService.saveReservation(model);
    }

    @ApiOperation(value = "Sửa thông tin Reservation")
    @PutMapping(value = "/reservations/{id}")
    public ReservationsDTO updateReservation(@RequestBody ReservationsDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return reservationsService.saveReservation(model);
    }



    @ApiOperation(value = "Xóa Reservation")
    @DeleteMapping(value = "/reservations")
    public void deleteReservations(@RequestBody long[] ids) {
            reservationsService.deleteReservations(ids);

    }
}
