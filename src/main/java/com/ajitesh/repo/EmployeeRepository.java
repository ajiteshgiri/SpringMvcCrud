package com.ajitesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajitesh.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
