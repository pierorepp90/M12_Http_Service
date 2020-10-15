package com.bcnit12.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcnit12.dto.Employee;

public interface IEmployee extends JpaRepository<Employee, Integer> {

	public List<Employee> findByName(String name);

	public List<Employee> findByJob(String job);

}
