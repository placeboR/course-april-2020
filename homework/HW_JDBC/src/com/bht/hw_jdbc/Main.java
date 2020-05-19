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
        Statement stmt = null;
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
                String sql_stmt = "SELECT * FROM employee WHERE job=\"" + job + "\"";
                stmt = con.createStatement();
                ResultSet rs_stmt = stmt.executeQuery(sql_stmt);
                System.out.println("Print the results from Statement:");
                while (rs_stmt.next()){
                    Employee e = new Employee();
                    e.setEmpid(rs_stmt.getInt("empid"));
                    e.setName(rs_stmt.getString("name"));
                    e.setJob(rs_stmt.getString("job"));
                    e.setManager(rs_stmt.getInt("manager"));
                    e.setHiredate(rs_stmt.getDate("hiredate"));
                    e.setSalary(rs_stmt.getDouble("salary"));
                    e.setDepid(rs_stmt.getInt("deptid"));
                    System.out.println(e);
                }
                System.out.println();
                pstmt.setString(1, job);
                ResultSet rs = pstmt.executeQuery();
                System.out.println("Printing results from PreparedStatement:");
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
                if (stmt != null) stmt.close();
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