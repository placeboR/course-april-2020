package org.hw2.DAO;

import java.sql.Connection;

public class DAOFactory {
    public static EmployeeDAOImpl getEmployeeDAOImpl(Connection conn){
        return new EmployeeDAOImpl(conn);
    }
    public static DepartmentDAOImpl getDepartmentDAOImpl(Connection conn){
        return new DepartmentDAOImpl(conn);
    }
}
