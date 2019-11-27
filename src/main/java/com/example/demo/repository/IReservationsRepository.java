package com.example.demo.repository;

import com.example.demo.entity.ReservationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationsRepository extends JpaRepository<ReservationsEntity, Long> {
    ReservationsEntity findOneById(long id);

}
