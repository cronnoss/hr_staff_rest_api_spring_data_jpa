package com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positions_employees")
public class PositionEmployee {

    @Id
    @Column(name = "posid")
    private int posid;

    @Id
    @Column(name = "empid")
    private int empid;

    public PositionEmployee() {
    }

    public PositionEmployee(int posid, int empid) {
        this.posid = posid;
        this.empid = empid;
    }

    public int getPosid() {
        return posid;
    }

    public void setPosid(int posid) {
        this.posid = posid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }
}