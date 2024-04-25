package com.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.program.entity.Employee;
import com.program.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp = service.getAllEmployee();
		m.addAttribute("emp", emp);
		return "index";
	}
	
	@GetMapping("/addEmp")
	public String addEmployeeForm() {
		return "add_employee";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {	  
		System.out.println(e);		
		service.addEmployee(e);	
		session.setAttribute("msg", "Employee added successfully");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEmployeeById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmployee(e);
		session.setAttribute("msg", "Employee Data Update Successfully");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		service.deleteEmployee(id);
		session.setAttribute("msg", "Employee Data delete Successfully");
		return "redirect:/";
	}
}
