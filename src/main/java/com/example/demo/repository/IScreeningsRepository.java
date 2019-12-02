package com.example.demo.repository;

import com.example.demo.entity.ScreeningsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScreeningsRepository extends JpaRepository<ScreeningsEntity,Long> {
}
