package org.hw2.service;

import org.hw2.beans.Employee;

import java.util.List;

public interface EmployeeService {
    public boolean insert(Employee e) throws Exception;
    public boolean update(Employee e) throws Exception;
    public boolean delete(Integer empid) throws Exception;
    public Employee findById(Integer empid) throws Exception;
    public List<Employee> findAll() throws Exception;
}
