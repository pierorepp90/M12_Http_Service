package com.bcnit12.service;

import java.util.List;

import com.bcnit12.dto.Employee;

public interface IEmployeeService {
	public Employee newEmployee(Employee employee);

	public Employee newEmployee(String name, String job);

	public List<Employee> showAll();

	public Employee showById(Integer id);

	public List<Employee> showByJob(String job);

	public Employee updateEmployee(Employee employee);

	public Employee updateEmployee(Integer id,String name, String job);

	public void deleteEmployee(Integer id);

	public void deleteEmployee(Employee employee);

	public List<Employee> showByName(String name);
}
