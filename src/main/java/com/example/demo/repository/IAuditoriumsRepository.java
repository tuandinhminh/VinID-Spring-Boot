package com.example.demo.repository;

import com.example.demo.entity.AuditoriumsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuditoriumsRepository extends JpaRepository<AuditoriumsEntity,Long> {
    AuditoriumsEntity findOneById(long id);
}
