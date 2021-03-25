package com.cronnoss.hr_staff_rest_api_spring_data_jpa.service;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartments();

    public void saveDepartment(Department department);

    public Department getDepartment(int depid);

    public void deleteDepartment(int depid);

    public List<Department> findDepartmentsByDepartmentNameContains(String departmentName);
//
//    public List<Department> findAllDepartmentsAndAverageSalary();
}