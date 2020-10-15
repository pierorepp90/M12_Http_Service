package com.bcnit12.controller;

import java.util.List;
import javax.management.AttributeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.bcnit12.dto.Employee;
import com.bcnit12.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/addbody")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) throws Exception{
		if(employee.getJob()==null || employee.getName()==null) {
			throw new AttributeNotFoundException("Name or job is empty.");	
		}
		return new ResponseEntity<>(service.newEmployee(employee),HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> newEmployee(@RequestParam String name, @RequestParam String job) throws Exception {
		return new ResponseEntity<>(service.newEmployee(name, job), HttpStatus.OK);

	}

	@GetMapping("/show")
	public ResponseEntity<List<Employee>> showAll() throws Exception {
		return new ResponseEntity<>(service.showAll(), HttpStatus.OK);
	}

	@GetMapping("/showid/{id}")
	public ResponseEntity<Employee> showById(@PathVariable(name = "id") Integer id) throws Exception {
		return new ResponseEntity<>(service.showById(id), HttpStatus.OK);
	}

	@GetMapping("/showname/{name}")
	public ResponseEntity<List<Employee>> showByName(@PathVariable(name = "name") String name) throws Exception {
		return new ResponseEntity<>(service.showByName(name), HttpStatus.OK);

	}

	@GetMapping("/showjob/{job}")
	public ResponseEntity<List<Employee>> showByJob(@PathVariable(name = "job") String job) throws Exception {
		return new ResponseEntity<>(service.showByJob(job), HttpStatus.OK);
	}

	@PutMapping("/updatebody/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") Integer id, @RequestBody Employee employee)
			throws Exception {
		Employee employeeDeprecated = service.showById(id);
		employeeDeprecated.setName(employee.getName());
		employeeDeprecated.setJob(employee.getJob());
		return new ResponseEntity<> (service.updateEmployee(employeeDeprecated),HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployeePath(@PathVariable(name = "id") Integer id, @RequestParam String name,
			@RequestParam String job) throws Exception {
		service.showById(id);
		return new ResponseEntity<>(service.updateEmployee(id, name, job),HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeId(@PathVariable Integer id) throws Exception {
		service.deleteEmployee(id);
	}

	@DeleteMapping("/deletebody")
	public void deleteEmployeeBody(@RequestBody Employee employee) throws Exception {
		service.deleteEmployee(employee);
	}

}
