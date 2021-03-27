package com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeRepositoryImpl /*implements EmployeeRepository*/{

//    @Autowired
//    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    public List<Employee> findDepartmentsAndAverageSalary() {
        Session session = sessionFactory.getCurrentSession();

        /*Query<Employee> query = session.createQuery("from Employee emp " +
                "left join Position " +
                "left join Employee " +
                "pe on emp.empid = pe.empid " +
                "left outer join Position p on p.posid = pe.posid " +
                "left join Department d on d.depid = p.depid " +
                "group by d.depid", Employee.class);*/

        Query<Employee> query = session.createSQLQuery("SELECT d.department_name as department, avg(emp.salary) as average_salary " +
                "FROM Employee emp " +
                "LEFT JOIN positions_employees pe on emp.empid = pe.empid " +
                "LEFT OUTER JOIN Position p on p.posid = pe.posid " +
                "LEFT JOIN Department d on d.depid = p.depid " +
                "GROUP BY d.depid");

        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }
}