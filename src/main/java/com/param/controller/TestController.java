package com.param.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.param.dto.Address;
import com.param.dto.Employee;
import com.param.services.EmployeeService;

@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/wish-globally")
	String wish() {
		return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
	}

	@GetMapping("/employees")
	List<Employee> listAll() {
		return employeeService.listAll();
	}

	@PostMapping("/employees")
	ResponseEntity<String> newEmployee(@Valid @RequestBody Employee newEmployee) {
		employeeService.newEmployee(newEmployee);
		return new ResponseEntity<>("Record created successfully!!", HttpStatus.CREATED);
	}
	
	@PostMapping("/employees/{id}/address")
	ResponseEntity<String> newEmployeeAddress(@PathVariable Long id, @RequestBody Address address) {
		employeeService.newEmployeeAddress(id, address);
		return new ResponseEntity<>("Record created successfully!!", HttpStatus.CREATED);
	}

	@GetMapping("/employees/{id}")
	Employee getEmpInfo(@PathVariable Long id) {
		return employeeService.getEmpInfo(id);
	}

	@PutMapping("/employees/{id}")
	Employee updateEmpInfo(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return employeeService.updateEmpInfo(newEmployee, id);
	}

	@DeleteMapping("/employees/{id}")
	ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
}
