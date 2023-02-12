package com.web.webproject.controller;

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

    private static Integer calculateSum(int valu1, int valu2) {
        return valu1 + valu2;
    }

    @GetMapping(value = "getSalaryDetails")
    public void getSalaryDetails(){
        System.out.println("The Salary Details");
    }
}
