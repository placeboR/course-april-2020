package com.bht.hw_jdbc;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static final String URL = "jdbc:mysql://localhost:3306/course?&useSSL=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "@Password123";

    public static void main(String[] args) throws Exception {
        Connection con = null;
        String driver="com.mysql.cj.jdbc.Driver";
        PreparedStatement pstmt = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!con.isClosed()) {
                System.out.println("Connected!");
                String sql = "SELECT * FROM employee WHERE job = ?";
                pstmt = con.prepareStatement(sql);
                String job = new String();
                System.out.println("Please type in the job type:");
                Scanner sc = new Scanner(System.in);
                job = sc.next();
                pstmt.setString(1, job);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()){
                    Employee e = new Employee();
                    e.setEmpid(rs.getInt("empid"));
                    e.setName(rs.getString("name"));
                    e.setJob(rs.getString("job"));
                    e.setManager(rs.getInt("manager"));
                    e.setHiredate(rs.getDate("hiredate"));
                    e.setSalary(rs.getDouble("salary"));
                    e.setDepid(rs.getInt("deptid"));
                    System.out.println(e);
                }
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not installed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed.");
        }finally{
            try{
                if(pstmt!=null) pstmt.close();
            }catch(SQLException se2){
            }// Do nothing
            try{
                if(con!=null) con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}