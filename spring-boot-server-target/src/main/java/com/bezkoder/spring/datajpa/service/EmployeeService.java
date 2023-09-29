package com.bezkoder.spring.datajpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bezkoder.spring.datajpa.model.Employee;
import com.bezkoder.spring.datajpa.repository.EmployeeRepository;

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> verifyCredentials(String emailId, String password) {
        return employeeRepository.findByEmailIdAndPassword(emailId, password);
    }
}
