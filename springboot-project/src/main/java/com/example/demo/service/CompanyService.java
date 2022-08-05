package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;

public interface CompanyService {

	Company saveAll(Company employee);

	Company findById(int empid);

	String updateEmpById(int empid,Employee employee);

	String  deleteById(int empid);

	String findByName(String empname);

	List<Employee> findAll();

}
