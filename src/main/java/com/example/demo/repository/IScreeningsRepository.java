package com.example.demo.repository;

import com.example.demo.entity.ScreeningsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IScreeningsRepository extends JpaRepository<ScreeningsEntity,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM screenings WHERE movie_id = :id")
    List<ScreeningsEntity> findAllByMovieId(@Param("id") Long id);
    @Query(nativeQuery = true, value = "SELECT * FROM screenings where start_time between :date1 and :date2")
    List<ScreeningsEntity> findAllByStartDate(@Param("date1") String date1,@Param("date2") String date2);
}
