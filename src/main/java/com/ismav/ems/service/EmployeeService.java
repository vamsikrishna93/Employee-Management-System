package com.ismav.ems.service;

import com.ismav.ems.model.EmployeeInfo;

import java.util.List;

public interface EmployeeService {
    EmployeeInfo createEmployee(EmployeeInfo employeeInfo);
    EmployeeInfo updateEmployee(EmployeeInfo employeeInfo, Long id);
    EmployeeInfo retrieveEmployee(Long id);
    List<EmployeeInfo> retrieveAll();
    void deleteEmployee(Long id);
}
