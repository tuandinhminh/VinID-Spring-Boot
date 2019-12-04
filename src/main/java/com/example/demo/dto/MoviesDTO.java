package com.example.demo.dto;

import com.example.demo.entity.ScreeningsEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoviesDTO extends BaseDTO {
    private String title;
    private int duration_min;
    private String image;
    private String description;
    private String status;
    List<ScreeningsDTO> screenings = new ArrayList<>();
    public MoviesDTO() {
    }

    public MoviesDTO(Long id, Date createdDate, Date modifiedDate, String title,
                     int duration_min, String image, String description, String status) {
        super(id, createdDate, modifiedDate);
        this.title = title;
        this.duration_min = duration_min;
        this.image = image;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration_min() {
        return duration_min;
    }

    public void setDuration_min(int duration_min) {
        this.duration_min = duration_min;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ScreeningsDTO> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<ScreeningsDTO> screenings) {
        this.screenings = screenings;
    }
}
