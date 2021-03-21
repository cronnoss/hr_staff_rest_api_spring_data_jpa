package com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.PositionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionEmployeeRepository extends JpaRepository<PositionEmployee, Integer> {
}