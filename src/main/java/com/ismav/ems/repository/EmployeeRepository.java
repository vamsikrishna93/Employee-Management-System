package com.ismav.ems.repository;

import com.ismav.ems.model.EmployeeInfo;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeInfo, Long> {
}
