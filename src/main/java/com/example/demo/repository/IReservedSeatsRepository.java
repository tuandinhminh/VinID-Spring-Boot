package com.example.demo.repository;

import com.example.demo.entity.ReservedSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReservedSeatsRepository extends JpaRepository<ReservedSeatsEntity,Long> {
    ReservedSeatsEntity findOneById(long id);
    @Query(nativeQuery = true, value = "SELECT * FROM reserved_seats WHERE reservation_id = :id")
    List<ReservedSeatsEntity> findAllByReservationId(@Param("id") Long id);
    @Query(nativeQuery = true, value = "SELECT * FROM reserved_seats WHERE screening_id = :id")
    List<ReservedSeatsEntity> findAllByScreeningId(@Param("id") Long id);
    @Modifying
    @Query(nativeQuery = true, value = "delete from reserved_seats WHERE reservation_id = :id")
    void deleteByReservationId(@Param("id") Long id);
}
