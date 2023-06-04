package com.web.webproject.controller;

import com.web.webproject.Repository.EmployeeRepository;
import com.web.webproject.model.EmployeeNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "employeeNew")
public class EmployeeNewController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "getEmployeeDetails")
    public ResponseEntity<?>  getEmployeeDetails() {
        List<EmployeeNew> listOfEmployee = this.employeeRepository.findAll();
        if(listOfEmployee!=null) {
            return new ResponseEntity<>(listOfEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping(value = "getEmployeeNewDetails/{employeeName}")
    public ResponseEntity<EmployeeNew> getExtendedEmployeeByName(@PathVariable("employeeName") String name) {

        List<EmployeeNew> listOfEmployee = this.employeeRepository.findByEmployeeName(name);
        if(listOfEmployee!=null) {
            return new ResponseEntity<>(listOfEmployee.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


    @GetMapping(value = "getEmployeeNewDetailsById/{id}")
    public ResponseEntity<EmployeeNew> getExtendedEmployeeById(@PathVariable("id") Long id) {

        EmployeeNew employeeObj = this.employeeRepository.findEmployeeNewById(id);
        if(employeeObj!=null) {
            return new ResponseEntity<>(employeeObj, HttpStatus.OK);
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

    @PutMapping(value = "/update-employee")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeNew employee) {

        // employee object is going to update
        // check employee exist
        EmployeeNew employeeObj = this.employeeRepository.findEmployeeNewById(employee.getId());
        //check null
        EmployeeNew updatedEmployee = this.employeeRepository.save(employeeObj);
        if (employeeObj != null) {
            //update
            return new ResponseEntity<>(updatedEmployee, HttpStatus.ACCEPTED);

        } else {
            // save
            return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
        }

    }

    @DeleteMapping(value = "delete-employee")
    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeeNew employee) {

        EmployeeNew employeeObj = this.employeeRepository.findEmployeeNewById(employee.getId());

        if (employeeObj !=null) {
            this.employeeRepository.deleteById(employeeObj.getId());
            return new ResponseEntity<>("Employee Object Was delted!!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee Object does not exit!", HttpStatus.NOT_FOUND);
        }
    }

    /*@GetMapping(value = "getEmplaoyeeByDepartmentId/{departentId}")
    public ResponseEntity<?> getEmplaoyeeByDepartmentId (@PathVariable("departmentId") Integer departmentId) {

        List<EmployeeNew> employee = this.employeeRepository.findEmployeeNewByDepartmentNew(departmentId);

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }*/

    private static Integer calculateSum(int valu1, int valu2) {
        return valu1 + valu2;
    }
}
