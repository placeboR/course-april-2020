package com.bht.hw_jdbc;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private int empid;
    private String name;
    private String job;
    private int manager;
    private Date hiredate;
    private double salary;
    private int depid;

    public Employee() {
        super();
    }

    public Employee(int empid, String name, String job, int manager, Date hiredate, double salary, int depid) {
        super();
        this.empid = empid;
        this.name = name;
        this.job = job;
        this.manager = manager;
        this.hiredate = hiredate;
        this.salary = salary;
        this.depid = depid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + manager +
                ", hiredate=" + hiredate +
                ", salary=" + salary +
                ", depid=" + depid +
                '}';
    }
}
