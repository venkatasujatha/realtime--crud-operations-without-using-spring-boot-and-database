package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;

	@NotNull
	@Size(min = 3, message = "Name should be atleast 3 characters")
	private String empname;

	@NotNull(message = "Salary id required")
	@Min(3)
	private Integer salary;

	@NotNull(message = "Phone number is required")
	@Size(min = 10, max = 10, message = "phone number should 10 digit only...")
	private String phoneno;

	public Employee(int empid,String empname,
			Integer salary,
			String phoneno) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
		this.phoneno = phoneno;
	}

	public Employee() {
		super();
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

}
