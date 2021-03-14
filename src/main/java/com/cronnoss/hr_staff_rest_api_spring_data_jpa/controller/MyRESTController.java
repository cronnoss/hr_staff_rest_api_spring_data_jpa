package com.cronnoss.hr_staff_rest_api_spring_data_jpa.controller;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Department;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> showAllDepartments() {
        List<Department> allDepartments = departmentService.getAllDepartments();
        return allDepartments;
    }

    @GetMapping("departments/{depid}")
    public Department getDepartment(@PathVariable int depid) {
        Department department = departmentService.getDepartment(depid);

        return department;
    }

    @PostMapping("/departments")
    public Department addNewDepartment(@RequestBody Department department) {

        departmentService.saveDepartment(department);
        return department;
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department) {

        departmentService.saveDepartment(department);
        return department;
    }

    @DeleteMapping("/departments/{depid}")
    public String deleteDepartment(@PathVariable int depid) {
        Department department = departmentService.getDepartment(depid);

        departmentService.deleteDepartment(depid);
        return "Department with ID = " + depid + " was deleted";
    }

    @GetMapping("/departments/departmentName/{departmentName}")
    public List<Department> showAllDepartmentsContainsDepartmentName(@PathVariable String departmentName) {
        List<Department> departments = departmentService.findDepartmentsByDepartmentNameContains(departmentName);

        return departments;
    }
}