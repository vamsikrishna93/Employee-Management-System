package com.ismav.ems.service;

import com.ismav.ems.exception.CustomBadRequestException;
import com.ismav.ems.exception.CustomConflictException;
import com.ismav.ems.exception.CustomException;
import com.ismav.ems.model.EmployeeInfo;
import com.ismav.ems.repository.EmployeeRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeInfo createEmployee(EmployeeInfo employeeInfo) throws Exception {
        try {
            return repository.save(employeeInfo);
        } catch (Exception e) {
            throw new CustomException("URL not found");
        }

    }

    @Override
    public EmployeeInfo updateEmployee(EmployeeInfo employeeInfo, Long id) throws Exception {
        try {
            EmployeeInfo employeeData = repository.findById(id).get();
            employeeInfo.setEmployeeId(id);
            if (!employeeData.equals(employeeInfo)) {
                return repository.save(employeeInfo);
            } else {
                System.out.println("Update not required");
            }
            return null;
        } catch (NoSuchElementException ex) {
            throw new CustomConflictException("There is no such ID in the DB");
        } catch (Exception e) {
            throw new CustomException("URL not found");
        }
    }


    @Override
    public EmployeeInfo retrieveEmployee(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<EmployeeInfo> retrieveAll() {
        Iterable<EmployeeInfo> employeeList = repository.findAll();
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        for (EmployeeInfo info : employeeList
        ) {
            employeeInfos.add(info);
        }
        return employeeInfos;
    }

    @Override
    public ResponseEntity<Object> deleteEmployee(Long id) throws Exception {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>("Record Deleted", HttpStatus.OK);
        } catch (EmptyResultDataAccessException ex) {
            throw new CustomConflictException("Record not present in the DB");
        } catch (Exception e) {
            throw new CustomException("URL IS WRONG");
        }

    }
}
