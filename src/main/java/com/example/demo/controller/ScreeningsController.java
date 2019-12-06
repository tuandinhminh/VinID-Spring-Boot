package com.example.demo.controller;

import com.example.demo.dto.ScreeningsDTO;
import com.example.demo.service.ScreeningsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScreeningsController {
    @Autowired
    private ScreeningsService screeningsService;
    @ApiOperation(value = "Lấy xuất chiếu theo ngày")
    @GetMapping(value = "screens/{date1}/{date2}")
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
}
