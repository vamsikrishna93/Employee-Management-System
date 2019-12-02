package com.ismav.ems.service;

import com.ismav.ems.model.EmployeeInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeInfo createEmployee(EmployeeInfo employeeInfo) throws Exception;
    EmployeeInfo updateEmployee(EmployeeInfo employeeInfo, Long id) throws Exception;
    EmployeeInfo retrieveEmployee(Long id);
    List<EmployeeInfo> retrieveAll();
    ResponseEntity<Object> deleteEmployee(Long id) throws Exception;
}
