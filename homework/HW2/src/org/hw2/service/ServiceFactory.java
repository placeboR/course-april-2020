package org.hw2.service;

import java.sql.SQLException;

public class ServiceFactory {
    static EmployeeServiceImpl getEmployeeServiceInstance() throws SQLException {
        return new EmployeeServiceImpl();
    }
    static DepartmentServiceImpl getDepartmentServiceInstance() throws SQLException{
        return new DepartmentServiceImpl();
    }
}
