package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cmpid;
	
	@NotNull(message = "company name required")
	private String cmpname;
	
	@NotNull(message = "company address required")
	private String address;
	@NotNull
	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", nullable = false,referencedColumnName = "cmpid")
	private List<Employee> employee;

	public int getCmpid() {
		return cmpid;
	}

	public void setCmpid(int cmpid) {
		this.cmpid = cmpid;
	}

	public String getCmpname() {
		return cmpname;
	}

	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Company(int cmpid, String cmpname, String address, List<Employee> employee) {
		super();
		this.cmpid = cmpid;
		this.cmpname = cmpname;
		this.address = address;
		this.employee = employee;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Company [cmpid=" + cmpid + ", cmpname=" + cmpname + ", address=" + address + ", employee=" + employee
				+ "]";
	}

}
