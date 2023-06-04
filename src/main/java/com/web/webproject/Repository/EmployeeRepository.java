package com.web.webproject.Repository;

import com.web.webproject.model.DepartmentNew;
import com.web.webproject.model.EmployeeNew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeNew, Long > {


    List<EmployeeNew> findByEmployeeName(String employeeName);
    //select * from Employee_NEw where employee_name = employeeName
    List<EmployeeNew> findByMobileNo(String mobileNo);

    @Override
    List<EmployeeNew> findAll();
    //select * from Employee_NEw

    // insert into EmloyeeDatabase values ("","","")

    EmployeeNew findEmployeeNewById(Long id);

    List<EmployeeNew> findEmployeeNewByDepartmentNew(DepartmentNew departmentId) ;


}
