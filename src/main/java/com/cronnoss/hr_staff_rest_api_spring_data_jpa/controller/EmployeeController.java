package com.cronnoss.hr_staff_rest_api_spring_data_jpa.controller;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Employee;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.service.EmployeeService;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.service.ReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

//    @GetMapping("/employees" )
//    public List<Employee> getReport(@RequestParam("dateOfBirth") ReportRequest dateOfBirth) {
//        List<Employee> employees = employeeService.findEmployeesByDateOfBirthContains(dateOfBirth.getFrom());
//        return employees;
//    }

//    @PostMapping("/employees")
//    public List<Employee> showAllEmployeesContainsDateOfBirth(@RequestParam(value="dateOfBirth", required = false) String dateOfBirth) {
//        //Create a DateTimeFormatter with your required format:
//        DateTimeFormat
//        DateTimeFormatter dateTimeFormat = new DateTimeFormatter(DateTimeFormatter.ISO_DATE_TIME);
//    }

//    @GetMapping(value = "dateOfBirth")
//    public List<Employee> showAllEmployeesContainsDateOfBirth(@RequestParam("dateOfBirth")
//                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Timestamp employeeDateOfBirth) {
//        List<Employee> employees = employeeService.findEmployeesByDateOfBirthContains(employeeDateOfBirth);
//        return employees;
//    }

//    @GetMapping("/employees/employeeDateOfBirth/{employeeDateOfBirth}")
//    public List<Employee> showAllEmployeesContainsDateOfBirth(@PathVariable
//                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Timestamp employeeDateOfBirth) {
//        List<Employee> employees = employeeService.findEmployeesByDateOfBirthContains(employeeDateOfBirth);
//        return employees;
//    }
}