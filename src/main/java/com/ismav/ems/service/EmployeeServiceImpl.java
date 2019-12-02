package com.ismav.ems.service;

import com.ismav.ems.model.EmployeeInfo;
import com.ismav.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeInfo createEmployee(EmployeeInfo employeeInfo) {
        return repository.save(employeeInfo);
    }

    @Override
    public EmployeeInfo updateEmployee(EmployeeInfo employeeInfo, Long id) {
        EmployeeInfo employeeData = repository.findById(id).get();
        employeeInfo.setEmployeeId(id);
        if (!employeeData.equals(employeeInfo)){
            return repository.save(employeeInfo);
        }else {
            System.out.println("Update not required");
        }
        return null;
    }

    @Override
    public EmployeeInfo retrieveEmployee(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<EmployeeInfo> retrieveAll() {
         Iterable<EmployeeInfo> employeeList = repository.findAll();
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        for (EmployeeInfo info: employeeList
        ) {
            employeeInfos.add(info);
        }
        return employeeInfos;
    }

    @Override
    public ResponseEntity<Object> deleteEmployee(Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Record Deleted", HttpStatus.OK);
    }
}
