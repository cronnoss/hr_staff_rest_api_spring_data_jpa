package com.cronnoss.hr_staff_rest_api_spring_data_jpa.controller;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Employee;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("employees/{empid}")
    public Employee getEmployee(@PathVariable int empid) {
        Employee employee = employeeService.getEmployee(empid);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{empid}")
    public String deleteEmployee(@PathVariable int empid) {
        employeeService.deleteEmployee(empid);
        return "Position with ID = " + empid + " was deleted";
    }

    @GetMapping("/employees/employeeName/{employeeFullName}")
    public List<Employee> showAllEmployeesByEmployeeFullName(@PathVariable String employeeFullName) {
        List<Employee> employees = employeeService.findEmployeesByFullName(employeeFullName);
        return employees;
    }
}