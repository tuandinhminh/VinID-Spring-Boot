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
    List<UsersEntity> findAllByEmail(@Param("email") String email, Pageable pageable);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE user_name LIKE :user_name")
    UsersEntity findOneByUserName(@Param("user_name") String name);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = :email")
    UsersEntity findOneByEmail(@Param("email") String email);
}
