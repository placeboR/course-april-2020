package org.hw2.DAO;

import org.hw2.beans.Department;
import org.hw2.beans.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    private Connection conn;
    private PreparedStatement ps;
    DepartmentDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public List<Department> findAllDepartment() throws Exception {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * from department";
        this.ps = this.conn.prepareStatement(sql);
        ResultSet rs = this.ps.executeQuery();
        while (rs.next()){
            Department d = new Department();
            d.setDepid(rs.getInt(1));
            d.setName(rs.getString(2));
            d.setLoc(rs.getString(3));
        }
        return list;
    }

    @Override
    public Department findByID(Integer depid) throws Exception {
        Department d = null;
        String sql = "SELECT * FROM department WHERE depid=?";
        this.ps = this.conn.prepareStatement(sql);
        ResultSet rs = this.ps.executeQuery();
        while (rs.next()){
            d = new Department();
            d.setDepid(rs.getInt(1));
            d.setName(rs.getString(2));
            d.setLoc(rs.getString(3));
        }
        return d;
    }

    @Override
    public boolean doCreate(Department d) throws Exception {
        String sql = "INSERT INTO department(depid, name, loc) values(?,?,?)";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1, d.getDepid());
        this.ps.setString(2, d.getName());
        this.ps.setString(3, d.getLoc());
        return this.ps.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Department d) throws Exception {
        String sql = "UPDATE department SET depid=?, name=?, loc=?";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1, d.getDepid());
        this.ps.setString(2, d.getName());
        this.ps.setString(3, d.getLoc());
        return this.ps.executeUpdate() > 0;
    }

    @Override
    public boolean deleteByID(Integer depid) throws Exception {
        if(depid == null) {
            return false;
        }
        String sql = "DELETE FROM department WHERE depid =?";
        this.ps = this.conn.prepareStatement(sql);
        return this.ps.executeUpdate() == 1;
    }
}
