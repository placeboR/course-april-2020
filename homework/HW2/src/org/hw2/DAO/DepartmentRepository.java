package org.hw2.DAO;

import org.hw2.beans.Department;
import org.hw2.beans.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DepartmentRepository {
    static List<Department> departments;
    static {
        departments = new ArrayList<>();
        departments.add(new Department(1, "R&D", "California"));
    }
    public List<Department> getDepartments(){
        return departments;
    }
    public Department getDepartmentById(int id){
        return departments.stream().filter(d -> id == d.getDepid()).findFirst().orElse(null);
    }
    public void updateDepartment(Department temp){
        Department target = departments.stream().filter(e -> e.getDepid() == temp.getDepid()).findFirst().orElse(null);
        if (target != null){
            target = temp;
        }
    }
    public void updateDepartment(int id, Department temp){
        Department target = departments.stream().filter(e -> e.getDepid() == id).findFirst().orElse(null);
        if (target != null){
            temp.setDepid(id);
            target = temp;
        }
    }
    public void newDepartment(Department tmp){
        Department target = departments.stream().filter(e -> e.getDepid() == tmp.getDepid()).findFirst().orElse(null);
        if (target != null){
            return;
        }
        Optional<Integer> maxId = departments.stream().map(Department::getDepid).max(Integer::compareTo);
        if (maxId.isPresent()){
            tmp.setDepid(maxId.get() + 1);
        }
        else {
            tmp.setDepid(1);
        }
        departments.add(tmp);
    }
    public void deleteDepartmentById(int id){
        departments.removeIf(tmp -> id == tmp.getDepid());
    }
}
