package com.web.webproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "EmployeeNew")
@Data
public class EmployeeNew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "employee_name", unique=true )
    private String employeeName;
    @Column(name="mobile_no")
    private String mobileNo;
}
