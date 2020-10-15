package com.bcnit12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcnit12.dao.IEmployee;
import com.bcnit12.dto.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployee iEmployee;

	@Override
	public Employee newEmployee(Employee employee) {
		return iEmployee.save(employee);
	}

	@Override
	public Employee newEmployee(String name, String job) {
		return iEmployee.save(new Employee(name, job));

	}

	@Override
	public List<Employee> showAll() {
		return iEmployee.findAll();
	}

	@Override
	public Employee showById(Integer id) {
		return iEmployee.findById(id).get();
	}

	@Override
	public List<Employee> showByName(String name) {
		return iEmployee.findByName(name);

	}

	@Override
	public List<Employee> showByJob(String job) {
		return iEmployee.findByJob(job.toUpperCase());
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return iEmployee.save(employee);
	}

	@Override
	public Employee updateEmployee(Integer id,String name, String job) {
		return iEmployee.save(new Employee(id,name, job));
	}

	@Override
	public void deleteEmployee(Integer id) {
		iEmployee.deleteById(id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		iEmployee.delete(employee);
	}
}
