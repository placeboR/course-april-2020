package org.hw2.controller;

import org.hw2.DAO.EmployeeRepository;
import org.hw2.DTO.EmployeeDTO;
import org.hw2.beans.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerStatic {
    public EmployeeRepository dao = new EmployeeRepository();

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        return dao.getEmployees();
    }

    @GetMapping(value = "/get/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id){
        try {
            Employee e = dao.getEmployeeById(id);
            EmployeeDTO dto = new EmployeeDTO(200);
            dto.setEmployee(e);
            return dto;
        }catch (Exception e){
            EmployeeDTO dto = new EmployeeDTO(500);
            return dto;
        }
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee tmp){
        dao.updateEmployee(id, tmp);
    }

    @PostMapping("/new")
    public void newEmployee(@RequestBody Employee tmp){
        dao.newEmployee(tmp);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable int id){
        dao.deleteEmployeeById(id);
    }
}
