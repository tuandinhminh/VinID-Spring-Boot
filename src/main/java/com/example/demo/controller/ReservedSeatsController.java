package com.example.demo.controller;

import com.example.demo.dto.ReservedSeatsDTO;
import com.example.demo.service.ReservedSeatsService;
import com.example.demo.service.ScreeningsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservedSeatsController {
    @Autowired
    private ReservedSeatsService reservedSeatsService;
    @Autowired
    private ScreeningsService screeningsService;

    @ApiOperation(value = "lay danh sach cac ghe trong ve")
    @GetMapping(value = "/res_seat")
    public List<ReservedSeatsDTO> getReservedSeats(){
        return  reservedSeatsService.getReservedSeats();
    }

    @ApiOperation(value = "Them dat ghe")
    @PostMapping(value = "/res_seat")
    public ResponseEntity<?> createSeat(@RequestBody ReservedSeatsDTO dto){
        try {
            ReservedSeatsDTO dto1 = reservedSeatsService.saveReservedSeat(dto);
            screeningsService.updateAmount(dto.getScreening_id());
            return ResponseEntity.ok(dto1);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("co loi xay ra");
        }
    }

    @ApiOperation(value = "xoa ghe")
    @DeleteMapping(value = "/res_seat")
    public void deleteReservedSeats(@RequestBody long[] ids){
        reservedSeatsService.deleteReservedSeats(ids);
    }
}
