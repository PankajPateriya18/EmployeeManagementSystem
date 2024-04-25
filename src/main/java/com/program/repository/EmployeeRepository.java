package com.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.program.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
 //Query Annotation 
 // Named Query : @Param Annotation
	
	
	
	
}
