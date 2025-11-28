package com.example.golfserver.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 회원 정보
    @Column(unique = true, nullable = false)
    private String username; // 로그인 ID

    @Column(nullable = false)
    private String password; // 암호화된 비밀번호

    @Column(nullable = false)
    private String name; // 실명

    @Column(unique = true, nullable = false)
    private String phone; // 휴대폰 번호 (예약 확인 필수)

    private String role;

    private int point; // 보유 포인트

    private LocalDateTime joinDate; // 가입일

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus; // 계정 상태

    // 지금은 사용 안함
    private String provider;    // 'GOOGLE' 또는 'NAVER' 등
    private String providerId;  // 소셜 서비스에서 제공하는 고유 ID

    @Builder
    public User(String username, String password, String name, String phone, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.point = 0; // 초기 포인트 0 설정
        this.userStatus = UserStatus.ACTIVE; // 기본 상태 활성 설정
    }
    enum UserStatus {
        ACTIVE, INACTIVE, BLOCKED
    }
}
