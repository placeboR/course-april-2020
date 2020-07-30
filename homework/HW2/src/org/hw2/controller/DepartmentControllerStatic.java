package org.hw2.controller;

import org.hw2.DAO.DepartmentRepository;
import org.hw2.beans.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentControllerStatic {
    private DepartmentRepository dao = new DepartmentRepository();

    @GetMapping("/get/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id){
        Department d = dao.getDepartmentById(id);
        return new ResponseEntity<Department>(d, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Department> getDepartments(){
        return dao.getDepartments();
    }

    @PutMapping("/update/{id}")
    public void updateDepartment(@PathVariable int id, @RequestBody Department tmp){

        dao.updateDepartment(id, tmp);
    }

    @PostMapping("/new")
    public void newDepartment(@RequestBody Department tmp){
        dao.newDepartment(tmp);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeparment(@PathVariable int id){
        dao.deleteDepartmentById(id);
    }
}
