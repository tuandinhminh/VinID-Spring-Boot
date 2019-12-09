package com.example.demo.controller;

import com.example.demo.dto.ScreeningsDTO;
import com.example.demo.service.ScreeningsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
import java.util.List;

@RestController
public class ScreeningsController {
    @Autowired
    private ScreeningsService screeningsService;
    @ApiOperation(value = "Lấy xuất chiếu theo ngày")
    @GetMapping(value = "/screenings/{date1}/{date2}")
    public ResponseEntity<?> getScreeningsByStartDate(@PathVariable("date1") String date1,
                                                      @PathVariable("date2") String date2){
        List<ScreeningsDTO> dtos = screeningsService.getScreeningsByStartDate(date1,date2);
        if (dtos != null){
            return ResponseEntity.ok(dtos);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("không có dữ liệu nào");
        }
    }

    @ApiOperation(value = "Lay danh sach ghe theo id xuat chieu")
    @GetMapping(value = "/screenings/{id}")
    public ResponseEntity<?> getAllSeats(@PathVariable long id){
        return ResponseEntity.ok(screeningsService.getAllSeats(id));
    }

    @RolesAllowed("ROLE_ADMIN")
    @ApiOperation(value = "cap nhat thong tin xuat chieu")
    @PutMapping(value = "/screenings/{id}")
    public ResponseEntity<?> updateScreening(@RequestBody ScreeningsDTO dto, @PathVariable long id){
        try {
            dto.setId(id);
            return ResponseEntity.ok(screeningsService.saveScreening(dto));
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("co loi roi");
        }
    }

    @ApiOperation(value = "them xuat chieu")
    @PostMapping(value = "/screenings")
    public ResponseEntity<?> createScreening(@RequestBody ScreeningsDTO dto){
        try {
            return ResponseEntity.ok(screeningsService.saveScreening(dto));
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("co loi roi");
        }
    }
}
