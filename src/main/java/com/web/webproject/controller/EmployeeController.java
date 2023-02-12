package com.web.webproject.controller;

import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "getExtendedEmployeeDetails202")
    public ResponseEntity<String> getExtendedEmployeeDetailsWith202() {
        // sucess 202 , 200
        // failed 500, 404
        ResponseEntity responseEntity = new ResponseEntity<String>("return employee Info", HttpStatus.ACCEPTED);
        return responseEntity;

    }

    @GetMapping(value = "getExtendedEmployeeDetails200")
    public ResponseEntity<String> getExtendedEmployeeDetailsWith200() {
        // sucess 202 , 200
        // failed 500, 404
        ResponseEntity responseEntity = new ResponseEntity<String>("return employee Info", HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping(value = "getExtendedEmployeeDetailsWithError")
    public ResponseEntity<String> getExtendedEmployeeDetailsWithError() {
        // sucess 202 , 200
        // failed 500, 404
        ResponseEntity responseEntity = new ResponseEntity<String>("return employee Info Not found", HttpStatus.NOT_FOUND);
        return responseEntity;

    }

    @GetMapping(value = "getExtendedEmployeeDetailsWithError500")
    public ResponseEntity<String> getExtendedEmployeeDetailsWithError500() {
        // sucess 202 , 200
        // failed 500, 404
        ResponseEntity responseEntity = new ResponseEntity<String>("return employee Info server error", HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;

    }

    @GetMapping(value = "getExtendedEmployeeDetailsSuceesAndError")
    public ResponseEntity<String> getExtendedEmployeeDetailsSuceesAndError() {

        Integer no1 = 6;
        if(no1%2==0) {
            return new ResponseEntity<>("Even Number", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Odd Number", HttpStatus.NOT_FOUND);
        }

    }

    private static Integer calculateSum(int valu1, int valu2) {
        return valu1 + valu2;
    }
}
