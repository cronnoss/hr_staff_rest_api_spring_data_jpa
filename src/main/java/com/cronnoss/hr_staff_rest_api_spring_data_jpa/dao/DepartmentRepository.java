package com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public List<Department> findDepartmentsByDepartmentNameContains(String departmentName);

    @Query("SELECT d.departmentName as department, avg(emp.salary) as average_salary " +
            "FROM Employee emp " +
            "LEFT JOIN PositionEmployee pe on emp.empid = pe.empid " +
            "LEFT OUTER JOIN Position p on p.posid = pe.posid " +
            "LEFT JOIN Department d on d.depid = p.depid " +
            "GROUP BY d.depid")
    public List<Department> findAllDepartmentsAndAverageSalary();
}