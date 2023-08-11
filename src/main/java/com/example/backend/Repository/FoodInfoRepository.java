package com.example.backend.Repository;

import com.example.backend.Entity.FoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodInfoRepository extends JpaRepository<FoodInfo,Long> {
}
