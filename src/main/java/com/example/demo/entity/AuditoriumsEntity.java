package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "auditoriums")
public class AuditoriumsEntity extends BaseEntity {
    @Column
    private String name;
    @OneToMany(mappedBy = "auditorium")
    private List<ScreeningsEntity> screenings = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScreeningsEntity> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<ScreeningsEntity> screenings) {
        this.screenings = screenings;
    }
}
