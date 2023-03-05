package com.web.webproject.Repository;
import com.web.webproject.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeptRepository extends JpaRepository<Department, Integer >{

List<Department> findByDepartments
}
