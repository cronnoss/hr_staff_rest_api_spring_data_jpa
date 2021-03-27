package com.cronnoss.hr_staff_rest_api_spring_data_jpa.service;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao.EmployeeRepository;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int empid) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(empid);
        if (optional.isPresent()) {
            employee = optional.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int empid) {
        employeeRepository.deleteById(empid);
    }

    @Override
    public List<Employee> findEmployeesByFullName(String fullName) {
        List<Employee> employees = employeeRepository.findEmployeesByFullName(fullName);
        return employees;
    }

    @Override
    public List<Employee> findEmployeesByDateOfBirthContains(Timestamp dateOfBirth) {
        List<Employee> employees = employeeRepository.findEmployeesByDateOfBirthContains(dateOfBirth);
        return employees;
    }
}