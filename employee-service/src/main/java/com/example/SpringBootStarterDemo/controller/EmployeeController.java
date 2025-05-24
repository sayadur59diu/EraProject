package com.example.SpringBootStarterDemo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStarterDemo.model.Employee;
import com.example.SpringBootStarterDemo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository _employeeRepository;
	@GetMapping
	public List<Employee> getAll(){
		return _employeeRepository.findAll();
	}

	@PostMapping
	public Employee addEmployee(@RequestBody Employee  employee) {
		return _employeeRepository.save(employee);
	}

	@GetMapping("/{id}")
	public Employee getByid(@PathVariable int id) {
		return _employeeRepository.findById(id).orElse(null);
	}

	@PutMapping
	public Employee update(@RequestBody Employee employee) {
		return _employeeRepository.save(employee);
	}

	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		_employeeRepository.deleteById(id);
		return "Delete Successfully";
	}


}
