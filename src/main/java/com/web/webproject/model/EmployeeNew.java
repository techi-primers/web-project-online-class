package com.web.webproject.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "EmployeeNew")
@Data
public class EmployeeNew implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeNew that = (EmployeeNew) o;
        return Objects.equals(employeeName, that.employeeName) && Objects.equals(mobileNo, that.mobileNo) && Objects.equals(departmentNew, that.departmentNew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName, mobileNo, departmentNew);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "employee_name", unique=true )
    private String employeeName;
    @Column(name="mobile_no")
    private String mobileNo;

    @ManyToOne
    private DepartmentNew departmentNew;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date modifiedDate;


}
