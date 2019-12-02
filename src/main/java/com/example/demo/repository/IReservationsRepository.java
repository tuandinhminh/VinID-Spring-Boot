package com.example.demo.repository;

import com.example.demo.entity.ReservationsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReservationsRepository extends JpaRepository<ReservationsEntity, Long> {
    ReservationsEntity findOneById(long id);
    @Query(nativeQuery = true, value = "SELECT * FROM reservations WHERE user_id = :id")
    List<ReservationsEntity> findOneByUserId(@Param("id") Long id);
}
