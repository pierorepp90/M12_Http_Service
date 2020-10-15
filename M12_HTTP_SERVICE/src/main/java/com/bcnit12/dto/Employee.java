package com.bcnit12.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "job")
	private String job;
	@Column(name = "salary")
	private Integer salary;

	public Employee() {
	}

	public Employee(int id, String name, String job) {
		this.id = id;
		this.name = name;
		Jobs j = stringToJob(job);
		this.job = j.toString();
		this.salary = jobToSalary(j);
	}

	public Employee(String name, String job) {
		this.name = name;
		Jobs j = stringToJob(job);
		this.job = j.toString();
		this.salary = jobToSalary(j);

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJob(String job) {
		Jobs j = stringToJob(job);
		this.job = j.toString();
		this.salary = jobToSalary(j);
	}

	public enum Jobs {
		DEFAULTJOB, ARCHITECT, JUNIOR, SENIOR, SERVICE, MAINTENANCE;

	}

	public Jobs stringToJob(String job) {
		try {
			return Jobs.valueOf(job.toUpperCase());
		} catch (Exception e) {
			return Jobs.DEFAULTJOB;
		}
	}

	public Integer jobToSalary(Jobs job) {
		Integer salary;
		switch (job) {

		case ARCHITECT:
			salary = 3500;
			break;
		case JUNIOR:
			salary = 1200;
			break;
		case SENIOR:
			salary = 2800;
			break;
		case SERVICE:
			salary = 2000;
			break;
		case MAINTENANCE:
			salary = 2200;
			break;
		default:
			salary = 0;
			break;
		}
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}

}
