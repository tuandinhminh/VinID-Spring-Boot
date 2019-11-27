package com.example.demo.repository;

import com.example.demo.entity.UsersEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IUsersRepository extends JpaRepository<UsersEntity,Long> {
    UsersEntity findOneById(long id);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email LIKE %:email%")
    List<UsersEntity> findOneByEmail(@Param("email") String email, Pageable pageable);
}
