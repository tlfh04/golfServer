package com.example.golfserver.repository;

import com.example.golfserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // 로그인ID로 User 객체 찾기
    Optional<User> findByUsername(String username);
    // 핸드폰번호로 User 객체 찾기
    Optional<User> findByPhone(String phone);
}
