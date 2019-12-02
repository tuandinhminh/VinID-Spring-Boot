package com.example.demo.repository;

import com.example.demo.entity.ReservedSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReservedSeatsRepository extends JpaRepository<ReservedSeatsEntity,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM reserved_seats WHERE reservation_id = :id")
    List<ReservedSeatsEntity> findAllByReservationId(@Param("id") Long id);
    @Query(nativeQuery = true, value = "SELECT FROM reserved_seats WHERE reservation_id = :id")
    List<ReservedSeatsEntity> deleteByReservationId(@Param("id") Long id);
}
