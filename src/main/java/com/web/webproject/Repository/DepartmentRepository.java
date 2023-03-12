package com.web.webproject.Repository;

import com.web.webproject.model.DepartmentNew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentNew, Integer> {
}
