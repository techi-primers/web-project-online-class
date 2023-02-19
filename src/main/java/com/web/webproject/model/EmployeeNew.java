package com.web.webproject.model;

import javax.persistence.*;

@Entity
@Table(name = "EmployeeNew")
public class EmployeeNew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "employee_name")
    private String employeeName;
    @Column(name="mobile_no")
    private String mobileNo;
}
