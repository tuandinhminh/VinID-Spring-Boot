package com.example.demo.controller;

import com.example.demo.dto.MoviesDTO;
import com.example.demo.dto.ScreeningsDTO;
import com.example.demo.form.Response;
import com.example.demo.service.MoviesService;
import com.example.demo.service.ReservedSeatsService;
import com.example.demo.service.ScreeningsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;
import java.util.List;
@Api(description = "API yeu cau quyen ADMIN tru API get")
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
    public ResponseEntity<?> getMovies(){
        List<MoviesDTO> dtos = moviesService.getMovies();
        for(MoviesDTO item: dtos){
            List<ScreeningsDTO> dtos1 = screeningsService.getScreeningsByMovieId(item.getId());
            for (ScreeningsDTO item1: dtos1){
                item1.setReservedSeats(reservedSeatsService.getReservedSeatsByScreeningId(item1.getId()));
            }
            item.setScreenings(dtos1);

        }
        return ResponseEntity.ok(new Response(dtos.size(),dtos));
    }
    @RolesAllowed("ROLE_ADMIN")
    @ApiOperation(value = "them phim")
    @PostMapping(value = "/movies")
    public ResponseEntity<?> postMovie(@RequestBody MoviesDTO dto){
        MoviesDTO dto1 = moviesService.saveMovie(dto);
        if (dto1 != null){
            return ResponseEntity.ok(dto1);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("co loi xay ra");
    }

    @RolesAllowed("ROLE_ADMIN")
    @ApiOperation(value = "sua phim")
    @PutMapping(value = "/movies/{id}")
    public  ResponseEntity<?> putMovie(@RequestBody MoviesDTO dto,@PathVariable long id){
        dto.setId(id);
        if (moviesService.saveMovie(dto) != null){
            return ResponseEntity.ok(moviesService.saveMovie(dto));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("co loi xay ra");
    }

    @RolesAllowed("ROLE_ADMIN")
    @ApiOperation(value = "xoa phim")
    @DeleteMapping(value = "/movies")
    public ResponseEntity<?> deleteMovie(@RequestBody long[] ids){
        moviesService.deleteMovies(ids);
        return ResponseEntity.status(HttpStatus.OK).body("xoa thanh cong");
    }
}
