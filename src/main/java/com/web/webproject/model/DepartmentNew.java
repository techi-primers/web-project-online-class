package com.web.webproject.model;

import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.List;

@Entity
@Table(name = "DepartmentNew")
@Data
public class DepartmentNew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer departmentId;

    private String departmentName;

}
