package com.param.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.param.dto.Address;
import com.param.dto.AddressRepository;
import com.param.dto.Employee;
import com.param.dto.EmployeeRepository;
import com.param.exceptions.EmployeeNotFoundException;

@Component
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	AddressRepository addressRepository;

	public List<Employee> listAll() {
		return repository.findAll();
	}

	public ResponseEntity<String> newEmployee(Employee newEmployee) {
		repository.save(newEmployee);
		return new ResponseEntity<>("Record created successfully!!", HttpStatus.CREATED);
	}
	
	public ResponseEntity<String> newEmployeeAddress(Long id, Address address) {
		Optional<Employee> emp=repository.findById(id);
		address.setEmployee(emp.get());
		addressRepository.save(address);
		return new ResponseEntity<>("Record created successfully!!", HttpStatus.CREATED);
	}

	public Employee getEmpInfo(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	public Employee updateEmpInfo(Employee newEmployee, Long id) {
		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			return repository.save(employee);
		}).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	public ResponseEntity<String> deleteEmployee(Long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>("Record created successfully!!",HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			throw new EmployeeNotFoundException(id);
		}
	}

}
