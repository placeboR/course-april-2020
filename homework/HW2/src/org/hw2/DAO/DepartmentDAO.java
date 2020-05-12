package org.hw2.DAO;

import org.hw2.beans.Department;
import org.hw2.beans.Employee;

import java.util.List;

public interface DepartmentDAO {
    List<Department> findAllDepartment() throws Exception;
    Department findByID(Integer depid) throws Exception;
    boolean doCreate(Department d) throws Exception;
    boolean doUpdate(Department d) throws Exception;
    boolean deleteByID(Integer depid) throws Exception;
}
