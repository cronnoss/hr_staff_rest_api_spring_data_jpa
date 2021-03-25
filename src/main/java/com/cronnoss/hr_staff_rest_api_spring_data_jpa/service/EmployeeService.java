package com.cronnoss.hr_staff_rest_api_spring_data_jpa.service;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int empid);

    public void deleteEmployee(int empid);

    public List<Employee> findEmployeesByFullName(String fullName);
//
//    public List<Employee> findAllBySalaryAndSalaryAndPositions();
}