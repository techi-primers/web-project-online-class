package com.web.webproject.controller;


import com.web.webproject.Repository.EmployeeRepository;
import com.web.webproject.model.EmployeeNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "employeeV2")
@Slf4j
public class EmployeeV2Controller {

    @Autowired
    EmployeeRepository employeeRepository;

    @PutMapping(value = "/update-employee-v2")
    public ResponseEntity<?> updateEmployee(@RequestBody List<EmployeeNew> employeeV2List) {
        List<EmployeeNew> toBeUpdate = new ArrayList<>();

        if(employeeV2List != null) {

            for (EmployeeNew employeeFromUser : employeeV2List) {

                    EmployeeNew employeeObjFromDb = this.employeeRepository.findEmployeeNewById(employeeFromUser.getId());

                    if (!employeeObjFromDb.equals(employeeFromUser)) {

                        toBeUpdate.add(employeeFromUser);

                    }

            }
        }

        toBeUpdate.forEach(rec -> {
            rec.setModifiedDate(new java.util.Date());
            this.employeeRepository.save(rec);
        });

        return new ResponseEntity<>(toBeUpdate.size() + " record count were update", HttpStatus.ACCEPTED);

    }


    @DeleteMapping(value = "delete-employee-v2/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") List<Long> ids) {

        List<EmployeeNew> toBeDelete = new ArrayList<>();
        for(Long id : ids) {
            EmployeeNew employeeObj = this.employeeRepository.findEmployeeNewById(id);
            if(employeeObj!=null) {
                log.info("Employee : {} going to delete",employeeObj);

                toBeDelete.add(employeeObj);
            }
        }

        toBeDelete.forEach(rec -> {
            rec.setModifiedDate(new java.util.Date());
            this.employeeRepository.deleteById(rec.getId());
        });

        return new ResponseEntity<>(toBeDelete.size() + " record count were delete", HttpStatus.ACCEPTED);
    }
}
