package com.example.demo.repository;

import com.example.demo.entity.ReservedSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservedSeatsRepository extends JpaRepository<ReservedSeatsEntity,Long> {
}
