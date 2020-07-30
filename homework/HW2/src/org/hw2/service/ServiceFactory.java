package org.hw2.service;

import java.sql.SQLException;

public class ServiceFactory {
    public static EmployeeServiceImpl getEmployeeServiceInstance() throws SQLException {
        return new EmployeeServiceImpl();
    }
    public static DepartmentServiceImpl getDepartmentServiceInstance() throws SQLException{
        return new DepartmentServiceImpl();
    }
}
