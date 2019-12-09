package com.example.demo.repository;

import com.example.demo.entity.SeatTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeatTypesRepository extends JpaRepository<SeatTypesEntity,Long> {
    SeatTypesEntity findOneById(long id);
}
