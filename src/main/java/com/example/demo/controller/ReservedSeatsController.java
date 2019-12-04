package com.example.demo.controller;

import com.example.demo.dto.ReservedSeatsDTO;
import com.example.demo.service.ReservedSeatsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservedSeatsController {
    @Autowired
    ReservedSeatsService reservedSeatsService;
    @ApiOperation(value = "lay danh sach cac ghe trong ve")
    @GetMapping(value = "/res_seat")
    public List<ReservedSeatsDTO> getReservedSeats(){
        return  reservedSeatsService.getReservedSeats();
    }

    @ApiOperation(value = "xoa")
    @DeleteMapping(value = "/res_seat")
    public void deleteReservedSeats(@RequestBody long[] ids){
        reservedSeatsService.deleteReservedSeats(ids);
    }
}
