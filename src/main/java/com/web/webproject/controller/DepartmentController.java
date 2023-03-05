package com.web.webproject.controller;

import com.web.webproject.Repository.DeptRepository;
import com.web.webproject.model.Department;
import com.web.webproject.model.EmployeeNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "Department")
public class DepartmentController {

    @Autowired
    DeptRepository deptRepository;

    @GetMapping(value = "getDeptDetails")
    public void getDeptDetails() {
        System.out.println("Hello I will send all the department Details..");
        //System.out.println(EmployeeNewController.calculateSum(12,34));
    }


    @GetMapping(value = "getDepartmentDetails/{departmentName}")
    public ResponseEntity<Department> getExtendedDepartmentById(@PathVariable("departmentName") String name) {

        List<Department> listOfDept = this.deptRepository.findByName(name);
        if(listOfDept!=null) {
            System.out.println("Hello world");

             return new ResponseEntity<>(listOfDept.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
