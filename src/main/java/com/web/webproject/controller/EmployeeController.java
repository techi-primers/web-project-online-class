package com.web.webproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @GetMapping(value = "getEmployeeDetails")
    public void getEmployeeDetails() {
        System.out.println("Hello I will send all the employee Details..");
        System.out.println(EmployeeController.calculateSum(12,34));
    }


    @GetMapping (value = "getSalaryDetails")
    public void getSalaryDetails() {
        System.out.println("This is the salary detsils - updated ");
    }



    @GetMapping (value = "getOtherDetails")
    public void getOtherDetails() {

        ResponseEntity responseEntity = new ResponseEntity<String> (body: Server Error)
        System.out.println("This is the salary detsils - updated ");
    }

    private static Integer calculateSum(int valu1, int valu2) {
        return valu1 + valu2;
    }
}
