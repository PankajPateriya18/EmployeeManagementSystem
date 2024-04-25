package com.program.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.program.entity.Employee;
import com.program.repository.EmployeeRepository;

@Service
public class EmployeeService {
// Create New Methods by And and Or Words
	//Api 
	
	@Autowired
	private EmployeeRepository repository;

	public void addEmployee(Employee e) {
		repository.save(e);
	}

	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	public Employee getEmployeeById(int id) {
		Optional<Employee> e = repository.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEmployee(int id) {
		repository.deleteById(id);
	}
}
