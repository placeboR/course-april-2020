package org.hw2.DAO;

import org.hw2.beans.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection conn;
    private PreparedStatement ps;
    EmployeeDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public List<Employee> findAllEmployee() throws Exception {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * from employee";
        this.ps = this.conn.prepareStatement(sql);
        ResultSet rs = this.ps.executeQuery();
        while (rs.next()){
            Employee e = new Employee();
            e.setEmpid(rs.getInt(1));
            e.setName(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setManager(rs.getInt(4));
            e.setHiredate(rs.getDate(5));
            e.setSalary(rs.getDouble(6));
            e.setDepid(rs.getInt(7));
        }
        return list;
    }

    @Override
    public Employee findByID(Integer empid) throws Exception {
        Employee e = null;
        String sql = "SELECT * FROM employee WHERE empid=?";
        this.ps = this.conn.prepareStatement(sql);
        ResultSet rs = this.ps.executeQuery();
        while (rs.next()){
            e = new Employee();
            e.setEmpid(rs.getInt(1));
            e.setName(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setManager(rs.getInt(4));
            e.setHiredate(rs.getDate(5));
            e.setSalary(rs.getDouble(6));
            e.setDepid(rs.getInt(7));
        }
        return e;
    }

    @Override
    public boolean doCreate(Employee e) throws Exception {
        String sql = "INSERT INTO employee(empid, name, job, manager, hiredate, salary, depid) values(?,?,?,?,?,?,?)";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1, e.getEmpid());
        this.ps.setString(2, e.getName());
        this.ps.setString(3, e.getJob());
        this.ps.setInt(4, e.getManager());
        this.ps.setDate(5, (Date) e.getHiredate());
        this.ps.setDouble(6, e.getSalary());
        this.ps.setInt(7, e.getDepid());
        return this.ps.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Employee e) throws Exception {
        String sql = "UPDATE employee SET empid=?, name=?, job=?, manager=?, hiredate=?, salary=?, depid=?";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1, e.getEmpid());
        this.ps.setString(2, e.getName());
        this.ps.setString(3, e.getJob());
        this.ps.setInt(4, e.getManager());
        this.ps.setDate(5, (Date) e.getHiredate());
        this.ps.setDouble(6, e.getSalary());
        this.ps.setInt(7, e.getDepid());
        return this.ps.executeUpdate() > 0;
    }

    @Override
    public boolean deleteByID(Integer empid) throws Exception {
        if(empid == null) {
            return false;
        }
        String sql = "DELETE FROM employee WHERE empid =?";
        this.ps = this.conn.prepareStatement(sql);
        return this.ps.executeUpdate() == 1;
    }
}
