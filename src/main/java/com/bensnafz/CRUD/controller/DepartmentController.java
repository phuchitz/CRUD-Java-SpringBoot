package com.bensnafz.CRUD.controller;
import com.bensnafz.CRUD.entity.Department;
import com.bensnafz.CRUD.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
public class DepartmentController {

    @Autowired private DepartmentService departmentService;

    //Save
    @PostMapping("/departments")

    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    //Read
    @GetMapping("/departments")

    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    //Update
    @PutMapping("/departments/{id}")

    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId){
        return departmentService.updateDepartment(department, departmentId);
    }

    //Delete
    @DeleteMapping("/departments/{id}")

    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }
}
