package com.ismav.ems.resource;

import com.ismav.ems.model.EmployeeInfo;
import com.ismav.ems.repository.EmployeeRepository;
import com.ismav.ems.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/ems")
public class EmployeeResource {

    private final Logger logger = LogManager.getLogger(EmployeeResource.class);

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService service;

    @GetMapping("/health-check")
    private String getHealthCheck() {
        return "Ok";
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    private EmployeeInfo createEmployee(@RequestBody @Valid EmployeeInfo employeeInfo) throws Exception {
        logger.info("Employee creating...");
        return service.createEmployee(employeeInfo);
    }

    @PutMapping("/employee/{id}")
    private EmployeeInfo updateEmployee(@RequestBody @Valid EmployeeInfo employeeInfo, @PathVariable Long id) throws Exception {
        logger.info("Employee with EmployeeId: {} is updating ... ", +id);
        return service.updateEmployee(employeeInfo, id);
    }

    @DeleteMapping("/employee/{id}")
    private ResponseEntity<Object> deleteEmployee(@PathVariable Long id) throws Exception {
        logger.info("Deleting Employee with Id: {} ", +id);
        return service.deleteEmployee(id);
    }

    @GetMapping("/employee/{id}")
    private EmployeeInfo retrieveEmployee(@PathVariable Long id) throws Exception {
        logger.info("Retrieving EmployeeInfo of Id: {} " ,+id);
        return service.retrieveEmployee(id);
    }

    @GetMapping("/employee")
    private List<EmployeeInfo> retrieveAllEmployees() {
        logger.info("Retrieving all employees from DB ...");
        return service.retrieveAll();
    }

}
