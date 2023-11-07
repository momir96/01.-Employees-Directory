package com.project.springboot.EmployeeDirectory.service;

import java.util.List;

import com.project.springboot.EmployeeDirectory.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
