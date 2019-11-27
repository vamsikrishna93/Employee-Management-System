package com.ismav.ems.resource;

import com.ismav.ems.model.EmployeeInfo;
import com.ismav.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/ems")
public class EmployeeResource {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/health-check")
    private String getHealthCheck(){
        return "Ok";
    }

    @PostMapping("/employee")
    private EmployeeInfo createEmployee(@RequestBody EmployeeInfo employeeInfo){
        return repository.save(employeeInfo);
    }

}
