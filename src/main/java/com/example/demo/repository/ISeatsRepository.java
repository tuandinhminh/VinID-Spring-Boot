package com.example.demo.repository;

import com.example.demo.entity.SeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeatsRepository extends JpaRepository<SeatsEntity,Long> {
}
