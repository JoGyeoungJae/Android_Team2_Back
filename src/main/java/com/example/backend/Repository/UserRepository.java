package com.example.backend.Repository;

import com.example.backend.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 별도의 메소드 선언이 필요 없음
}