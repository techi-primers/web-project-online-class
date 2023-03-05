package com.web.webproject.controller;

import com.web.webproject.Repository.EmployeeRepository;
import com.web.webproject.model.EmployeeNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "employeeNew")
public class EmployeeNewController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "getEmployeeDetails")
    public void getEmployeeDetails() {
        System.out.println("Hello I will send all the employee Details..");
        System.out.println(EmployeeNewController.calculateSum(12,34));
    }



    @GetMapping(value = "getEmployeeNewDetails/{employeeName}")
    public ResponseEntity<EmployeeNew> getExtendedEmployeeById(@PathVariable("employeeName") String name) {

        List<EmployeeNew> listOfEmployee = this.employeeRepository.findByEmployeeName(name);
        if(listOfEmployee!=null) {
            return new ResponseEntity<>(listOfEmployee.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping(value = "/save-employee")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeNew employeeNew) {
        EmployeeNew savedObject = this.employeeRepository.save(employeeNew);
        if(savedObject!=null) {
            return new ResponseEntity<>(savedObject, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Employee Not Persisted!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private static Integer calculateSum(int valu1, int valu2) {
        return valu1 + valu2;
    }
}
