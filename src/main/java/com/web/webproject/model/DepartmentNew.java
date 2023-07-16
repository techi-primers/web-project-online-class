package com.web.webproject.model;

import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DepartmentNew")
@Data
public class DepartmentNew {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentNew that = (DepartmentNew) o;
        return Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer departmentId;

    private String departmentName;

}
