package org.hw2.DTO;

import org.hw2.beans.Department;

public class DepartmentDTO extends ResultDTO {
    Department department;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int status) {
        super(status);
    }

    public DepartmentDTO(int status, Department department) {
        super(status);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getStatus(){
        return super.getStatus();
    }

    public void setStatus(int status){
        super.setStatus(status);
    }

}
