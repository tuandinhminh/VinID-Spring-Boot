package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersDTO extends BaseDTO {

    private String username;
    private String email;
    private String password;
    private String role;
    List<ReservationsDTO> reservations = new ArrayList<>();
    public UsersDTO() {
    }

    public UsersDTO(Long id, Date createdDate, Date modifiedDate, String username, String email, String password) {
        super(id, createdDate, modifiedDate);
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UsersDTO(Long id, Date createdDate, Date modifiedDate, String username, String email, String password, String role) {
        super(id, createdDate, modifiedDate);
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ReservationsDTO> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationsDTO> reservations) {
        this.reservations = reservations;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
