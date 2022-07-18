package com.ajitesh.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajitesh.model.Employee;
import com.ajitesh.repo.EmployeeRepository;
import com.ajitesh.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	EmployeeRepository repo;
	
	@Override
	public Integer saveEmployee(Employee e) {
		Double sal= e.getEmpSal();
		double hra=sal*20/100;
		double ta= sal*10/100;
		e.setEmpHra(hra);
		e.setTa(ta);
		Integer id = repo.save(e).getEmpId();
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void updateEmployee(Employee e) {
		if(repo.existsById(e.getEmpId())) {
			Double sal= e.getEmpSal();
			double hra=sal*20/100;
			double ta= sal*10/100;
			e.setEmpHra(hra);
			e.setTa(ta);
			repo.save(e);
		}
		
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Optional<Employee> getOneEmployee(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> emps= repo.findAll();
		return emps.stream().sorted((e1,e2)->e2.getEmpId().compareTo(e1.getEmpId())).collect(Collectors.toList());
	}

}
