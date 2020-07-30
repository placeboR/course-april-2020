package org.hw2.service;

import org.hw2.DAO.DAOFactory;
import org.hw2.beans.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
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
    EmployeeServiceImpl() throws SQLException {
        try{
            conn = getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.conn.close();
        }
    }
    @Override
    public boolean insert(Employee e) throws Exception {
        try {
            return DAOFactory.getEmployeeDAOImpl(this.conn).doCreate(e);
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }

    @Override
    public boolean update(Integer empid, Employee e) throws Exception {
        try {
            return DAOFactory.getEmployeeDAOImpl(this.conn).doUpdate(empid, e);
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }

    @Override
    public boolean delete(Integer empid) throws Exception {
        try {
            return DAOFactory.getEmployeeDAOImpl(this.conn).deleteByID(empid);
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }

    @Override
    public Employee findById(Integer empid) throws Exception {
        try {
            return DAOFactory.getEmployeeDAOImpl(this.conn).findByID(empid);
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }

    @Override
    public List<Employee> findAll() throws Exception {
        try {
            return DAOFactory.getEmployeeDAOImpl(this.conn).findAllEmployee();
        }catch(Exception exception) {
            throw exception;
        }finally {
            this.conn.close();
        }
    }
}
