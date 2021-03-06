package com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_empid_seq")
    @SequenceGenerator(initialValue = 7, name = "employee_empid_seq", allocationSize = 10)
    @Column(name = "empid")
    private int empid;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;

    @Column(name = "salary")
    private int salary;

    @ManyToMany(/*fetch = FetchType.LAZY, cascade = CascadeType.ALL*/)
    @JoinTable(
            name = "positions_employees"
            , joinColumns = @JoinColumn(name = "empid")
            , inverseJoinColumns = @JoinColumn(name = "posid"))
    private List<Position> positions;

    public Employee() {
    }

    public Employee(String fullName, Timestamp dateOfBirth, int salary) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    public void addPositionToEmployee(Position position) {
        if (positions == null) {
            positions = new ArrayList<>();
        }
        positions.add(position);
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                '}';
    }
}