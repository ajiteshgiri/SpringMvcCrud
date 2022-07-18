package com.ajitesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ajitesh.model.Employee;
import com.ajitesh.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class HomeController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/register")
	public String showReg() {
		return "EmployeeRegister";
	}
	
	public String saveEmp(@ModelAttribute Employee employee, Model model) {
		Integer id = service.saveEmployee(employee);
		String message = "Employee'"+id+"' created!!";
		model.addAttribute("message",message);
		return "EmployeeRegister";
	}
	
	@GetMapping("/all")
	public String getAllEmployee(Model model) {
		List<Employee> emps = service.getAllEmployees();
		model.addAttribute("list",emps);
		
		return "EmployeeData";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) {
		service.deleteEmployee(id);
		return "EmployeeData";
	}
	
	@GetMapping("/edit/{id}")
	public String getEmployeeById(@PathVariable Integer id,Model model) {
		Optional<Employee> emps = service.getOneEmployee(id);
		model.addAttribute("empById",emps);
		return "EmployeeRegister";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@RequestBody Employee emp,Model model) {
		 service.updateEmployee(emp);
		 model.addAttribute("message", "employee update successfully !!");
		 return "EmployeeData";
	}

}
