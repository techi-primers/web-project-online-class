package com.web.webproject.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.lang.annotation.RetentionPolicy;

@Entity
@Table(name="Department")
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column (name= "department_name")
    private String departmentName;

    @Column (name="no_of_employees")
    private int noOfEmployees;
}
