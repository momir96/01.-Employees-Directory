package com.project.springboot.EmployeeDirectory.controller;

import java.util.List;

import com.project.springboot.EmployeeDirectory.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.springboot.EmployeeDirectory.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();

		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {

		Employee theEmployee = employeeService.findById(theId);

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		employeeService.save(theEmployee);

		return "redirect:/employees/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		employeeService.deleteById(theId);

		return "redirect:/employees/list";

	}
}









