package org.hw2.service;

import org.hw2.beans.Department;

import java.util.List;

public interface DepartmentService {
    public boolean insert(Department d) throws Exception;
    public boolean update(Department d) throws Exception;
    public boolean delete(Integer depid) throws Exception;
    public Department findById(Integer depid) throws Exception;
    public List<Department> findAll() throws Exception;
}
