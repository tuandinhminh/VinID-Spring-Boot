package com.example.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class MoviesEntity extends BaseEntity{
    @Column(unique = true, nullable=false)
    private String title;
    @Column
    private int durationMin;
    @Column
    private String image;
    @Column(length = 2000)
    private String description;
    @Column
    private String status;
    @OneToMany(mappedBy = "movie")
    private List<ScreeningsEntity> screenings = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
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

    public List<ScreeningsEntity> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<ScreeningsEntity> screenings) {
        this.screenings = screenings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
