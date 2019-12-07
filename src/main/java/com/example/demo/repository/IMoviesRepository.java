package com.example.demo.repository;

import com.example.demo.entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMoviesRepository extends JpaRepository<MoviesEntity,Long> {
    MoviesEntity findOneById(Long id);
}
