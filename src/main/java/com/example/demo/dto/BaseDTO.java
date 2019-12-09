package com.example.demo.dto;

import java.util.Date;

public class BaseDTO {
    private Long id;
    private Date createdDate;
    private Date modifiedDate;

    public BaseDTO() {
    }

    public BaseDTO(Long id) {
        this.id = id;
    }

    public BaseDTO(Long id, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
