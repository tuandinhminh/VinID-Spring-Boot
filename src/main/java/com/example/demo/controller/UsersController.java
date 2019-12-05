package com.example.demo.controller;
import com.example.demo.dto.ReservationsDTO;
import com.example.demo.dto.UsersDTO;
import com.example.demo.form.AuthenticationRequest;
import com.example.demo.form.AuthenticationResponse;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.service.ReservationsService;
import com.example.demo.service.ReservedSeatsService;
import com.example.demo.service.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ReservationsService reservationsService;
    @Autowired
    private ReservedSeatsService reservedSeatsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @ApiOperation(value = "Lấy danh sách user")
    @GetMapping(value = "/users")
    public ResponseEntity<?> getUsers(){
        try{
            return ResponseEntity.ok(usersService.getUsers());
        }
        catch (Exception e){
            return ResponseEntity.status (HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi mất rồi");
        }

    }

    @ApiOperation(value = "thêm mới user")
    @PostMapping(value = "/users")
    public UsersDTO createUser(@RequestBody UsersDTO model) {
        return usersService.saveUser(model);
    }

    @ApiOperation(value = "Sửa thông tin user")
    @PutMapping(value = "/users/{id}")
    public UsersDTO updateUser(@RequestBody UsersDTO model, @PathVariable("id") Long id) {
        model.setId(id);
        return usersService.saveUser(model);
    }
    @RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
    @ApiOperation(value = "Lấy thông tin user theo id")
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id) {
        try {
            UsersDTO dto = usersService.getUserById(id);
            List<ReservationsDTO> dtos = reservationsService.getReservationsByUserId(id);
            for(ReservationsDTO item:dtos){
                item.setReservedSeatsDTOS(reservedSeatsService.getReservedSeatsByReservationsId(item.getId()));
            }
            dto.setReservations(dtos);
            return ResponseEntity.ok(dto);
        } catch (Exception e){
            return ResponseEntity.status (HttpStatus.NOT_FOUND).body("user khong ton tai");
        }

    }

    @ApiOperation(value = "Lấy thông tin user theo email")
    @GetMapping(value = "/user/{email}")
    public List<UsersDTO> getUserByEmail(@PathVariable("email") String email) {
        return usersService.getUserByEmail(email);
    }

    @ApiOperation(value = "Xóa user")
    @DeleteMapping(value = "/users")
    public void deleteUsers(@RequestBody long[] ids) {
        usersService.deleteUsers(ids);
    }

    @GetMapping("/test-transaction")
    public ResponseEntity<?> testTransaction() {
        try {
            return usersService.testTransaction();
        } catch (Exception e) {
            return ResponseEntity.status (HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi mất rồi");
        }
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request)
        throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }
        final UserDetails userDetails = usersService.loadUserByUsername(request.getUsername());
        final String jwt = "Bearer " + jwtUtil.generateToken(userDetails);
        UsersDTO dto = usersService.getOneByUserName(request.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(0L,"thanh cong",dto,jwt));
    }

}
