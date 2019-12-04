package com.example.demo.controller;

import com.example.demo.dto.MoviesDTO;
import com.example.demo.dto.ScreeningsDTO;
import com.example.demo.service.MoviesService;
import com.example.demo.service.ReservedSeatsService;
import com.example.demo.service.ScreeningsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
    @Autowired
    private MoviesService moviesService;
    @Autowired
    private ScreeningsService screeningsService;
    @Autowired
    private ReservedSeatsService reservedSeatsService;
    @ApiOperation(value = "get movie va xuat chieu tuong ung")
    @GetMapping(value = "/movies")
    public List<MoviesDTO> getMovies(){
        List<MoviesDTO> dtos = moviesService.getMovies();
        for(MoviesDTO item: dtos){
            List<ScreeningsDTO> dtos1 = screeningsService.getScreeningsByMovieId(item.getId());
            for (ScreeningsDTO item1: dtos1){
                item1.setReservedSeats(reservedSeatsService.getReservedSeatsByScreeningId(item1.getId()));
            }
            item.setScreenings(dtos1);

        }
        return dtos;
    }

}
