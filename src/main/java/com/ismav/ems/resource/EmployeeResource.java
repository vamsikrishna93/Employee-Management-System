package com.ismav.ems.resource;

import com.ismav.ems.model.EmployeeInfo;
import com.ismav.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    private EmployeeInfo createEmployee(@RequestBody @Valid EmployeeInfo employeeInfo){
        return repository.save(employeeInfo);
    }

    @PutMapping("/employee/{id}")
    private EmployeeInfo updateEmployee(@RequestBody @Valid EmployeeInfo employeeInfo, @PathVariable Long id){
        EmployeeInfo employeeData = repository.findById(id).get();
        employeeInfo.setEmployeeId(id);
        if (!employeeData.equals(employeeInfo)){
            return repository.save(employeeInfo);
        }else {
            System.out.println("Update not required");
        }
        return null;
    }

    @DeleteMapping("/employee/{id}")
    private void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/employee/{id}")
    private EmployeeInfo retriveEmployee(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @GetMapping("/employee")
    private List<EmployeeInfo> retriveAllEmployees(){
        Iterable<EmployeeInfo> employeeList = repository.findAll();
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        for (EmployeeInfo info: employeeList
             ) {
            employeeInfos.add(info);
        }
        return employeeInfos;
    }

}
