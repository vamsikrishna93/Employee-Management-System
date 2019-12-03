package com.ismav.ems.resource;

import com.ismav.ems.model.EmployeeInfo;
import com.ismav.ems.repository.EmployeeRepository;
import com.ismav.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/ems")
public class EmployeeResource {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService service;

    @GetMapping("/health-check")
    private String getHealthCheck() {
        return "Ok";
    }

    @PostMapping("/employee")
    private EmployeeInfo createEmployee(@RequestBody @Valid EmployeeInfo employeeInfo) throws Exception {
        return service.createEmployee(employeeInfo);
    }

    @PutMapping("/employee/{id}")
    private EmployeeInfo updateEmployee(@RequestBody @Valid EmployeeInfo employeeInfo, @PathVariable Long id) throws Exception {
        return service.updateEmployee(employeeInfo, id);
    }

    @DeleteMapping("/employee/{id}")
    private ResponseEntity<Object> deleteEmployee(@PathVariable Long id) throws Exception {
        return service.deleteEmployee(id);
    }

    @GetMapping("/employee/{id}")
    private EmployeeInfo retrieveEmployee(@PathVariable Long id) {
        return service.retrieveEmployee(id);
    }

    @GetMapping("/employee")
    private List<EmployeeInfo> retrieveAllEmployees() {
        return service.retrieveAll();
    }

}
