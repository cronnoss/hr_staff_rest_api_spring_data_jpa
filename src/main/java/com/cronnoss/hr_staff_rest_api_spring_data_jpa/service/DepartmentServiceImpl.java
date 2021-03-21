package com.cronnoss.hr_staff_rest_api_spring_data_jpa.service;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao.DepartmentRepository;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(int depid) {
        Department department = null;
        Optional<Department> optional = departmentRepository.findById(depid);
        if (optional.isPresent()) {
            department = optional.get();
        }
        return department;
    }

    @Override
    public void deleteDepartment(int depid) {
        departmentRepository.deleteById(depid);
    }

    @Override
    public List<Department> findDepartmentsByDepartmentNameContains(String departmentName) {
        List<Department> departments = departmentRepository
                .findDepartmentsByDepartmentNameContains(departmentName);
        return departments;
    }

    @Override
    public List<Department> findAllDepartmentsAndAverageSalary() {
        List<Department> departments = departmentRepository.findAllDepartmentsAndAverageSalary();
        return departments;
    }
}