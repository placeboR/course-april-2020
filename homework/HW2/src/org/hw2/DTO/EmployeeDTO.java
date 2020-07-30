package org.hw2.DTO;

import org.hw2.beans.Employee;

public class EmployeeDTO extends ResultDTO {
    Employee employee;

    public EmployeeDTO(int status) {
        super(status);
    }

    public EmployeeDTO(int status, Employee employee) {
        super(status);
        this.employee = employee;
    }

    public EmployeeDTO() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getStatus(){
        return super.getStatus();
    }

    public void setStatus(int status){
        super.setStatus(status);
    }

    public Employee gettargetObject(){
        return employee;
    }
    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employee=" + employee +
                ", status=" + status +
                '}';
    }
}
