package com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    public List<Position> findPositionsByPositionName(String positionName);
}