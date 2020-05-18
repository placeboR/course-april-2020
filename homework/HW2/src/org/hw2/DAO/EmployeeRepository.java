package org.hw2.DAO;

import org.hw2.beans.Employee;
import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAOSimple {
    static List<Employee> employees;
    static {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Tom", "Writer", 2, new Date(2020, 5, 23), 3600.00, 1));
    }
    public List<Employee> getEmployees(){
        return employees;
    }
    public Employee getEmployeeById(int id){
        return employees.stream().filter(e -> id == e.getDepid()).findFirst().orElse(null);
    }
    public void updateEmployee(Employee temp){
        Employee target = employees.stream().filter(e -> e.getEmpid() == temp.getEmpid()).findFirst().orElse(null);
        if (target != null){
            target = temp;
        }
    }
    public void newEmployee(Employee tmp){

        int maxId = employees.stream().map(e -> e.getEmpid()).max();
        tmp.setEmpid(maxId + 1);
    }
}
