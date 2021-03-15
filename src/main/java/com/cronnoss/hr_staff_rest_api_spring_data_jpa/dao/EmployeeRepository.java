package com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}