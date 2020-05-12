package org.hw2.DAO;

import org.hw2.beans.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployee() throws Exception;
    Employee findByID(Integer empid) throws Exception;
    boolean doCreate(Employee e) throws Exception;
    boolean doUpdate(Employee e) throws Exception;
    boolean deleteByID(Integer empid) throws Exception;
}
