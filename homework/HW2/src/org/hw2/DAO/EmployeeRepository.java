package org.hw2.DAO;

import org.hw2.beans.Employee;
import sun.util.calendar.BaseCalendar;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepository {
    static List<Employee> employees;
    static {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Tom", "Writer", 2, new Date(2020, 5, 23), 3600.00, 1));
    }
    public List<Employee> getEmployees(){
        return employees;
    }
    public Employee getEmployeeById(int id){
        return employees.stream().filter(e -> id == e.getEmpid()).findFirst().orElse(null);
    }
    public void updateEmployee(Employee temp){
        Employee target = employees.stream().filter(e -> e.getEmpid() == temp.getEmpid()).findFirst().orElse(null);
        if (target != null){
            target = temp;
        }
    }
    public void updateEmployee(int id, Employee temp){
        Employee target = employees.stream().filter(e -> e.getEmpid() == id).findFirst().orElse(null);
        if (target != null){
            temp.setEmpid(id);
            target = temp;
        }
    }
    public void newEmployee(Employee tmp){
        Employee target = employees.stream().filter(e -> e.getEmpid() == tmp.getEmpid()).findFirst().orElse(null);
        if (target != null){
            return;
        }
        Optional<Integer> maxId = employees.stream().map(Employee::getEmpid).max(Integer::compareTo);
        if (maxId.isPresent()){
            tmp.setEmpid(maxId.get() + 1);
        }
        else {
            tmp.setEmpid(1);
        }
        employees.add(tmp);
    }
    public void deleteEmployeeById(int id){
        employees.removeIf(tmp -> id == tmp.getEmpid());
    }
}
