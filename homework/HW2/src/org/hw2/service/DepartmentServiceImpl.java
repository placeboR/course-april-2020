package org.hw2.service;

import org.hw2.DAO.DAOFactory;
import org.hw2.beans.Department;
import org.hw2.beans.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/MySql80";
    private static String user="root";
    private static String password="123456";
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    Connection conn;
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    DepartmentServiceImpl() throws SQLException {
        try{
            conn = getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.conn.close();
        }
    }
    @Override
    public boolean insert(Department d) throws Exception {
        try {
            return DAOFactory.getDepartmentDAOImpl(this.conn).doCreate(d);
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }

    @Override
    public boolean update(Department d) throws Exception {
        try {
            return DAOFactory.getDepartmentDAOImpl(this.conn).doUpdate(d);
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }

    @Override
    public boolean delete(Integer depid) throws Exception {
        try {
            return DAOFactory.getDepartmentDAOImpl(this.conn).deleteByID(depid);
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }

    @Override
    public Department findById(Integer depid) throws Exception {
        try {
            return DAOFactory.getDepartmentDAOImpl(this.conn).findByID(depid);
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }

    @Override
    public List<Department> findAll() throws Exception {
        try {
            return DAOFactory.getDepartmentDAOImpl(this.conn).findAllDepartment();
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }
}
