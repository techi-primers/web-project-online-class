package com.web.webproject.controller;

import com.web.webproject.model.DepartmentNew;
import com.web.webproject.Repository.DepartmentRepository;
import com.web.webproject.model.EmployeeNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "DepartmentController")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping(value = "/save-department")
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentNew departmentNew) {


        //departmentNew.setEmployees(listOfEmployee);

        DepartmentNew savedDepartment = this.departmentRepository.save(departmentNew);

        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);


    }
}
