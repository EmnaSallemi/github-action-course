package com.bezkoder.spring.datajpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByUser(String user);

    List<Employee> findByEmailId(String emailId);
    
    Optional<Employee> findByEmailIdAndPassword(String emailId, String password);

}