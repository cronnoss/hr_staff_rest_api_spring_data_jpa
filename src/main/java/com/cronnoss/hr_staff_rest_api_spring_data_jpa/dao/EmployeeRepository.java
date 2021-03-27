package com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findEmployeesByFullName(String FullName);

//    @Query("SELECT department_name as department, avg(salary) as average_salary " +
//    "FROM employee emp " +
//    "LEFT JOIN positions_employees pe on emp.empid = pe.empid " +
//    "LEFT OUTER JOIN position p on p.posid = pe.posid " +
//    "LEFT JOIN department d on d.depid = p.depid " +
//    "GROUP BY d.depid")
//    public List<Employee> findDepartmentsAndAverageSalary();

    public List<Employee> findEmployeesByDateOfBirthContains(Timestamp dateOfBirth);
}