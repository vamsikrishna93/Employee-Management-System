package com.ismav.ems.service;

import com.ismav.ems.model.EmployeeInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeInfo createEmployee(EmployeeInfo employeeInfo);
    EmployeeInfo updateEmployee(EmployeeInfo employeeInfo, Long id);
    EmployeeInfo retrieveEmployee(Long id);
    List<EmployeeInfo> retrieveAll();
    ResponseEntity<Object> deleteEmployee(Long id);
}
