package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class ServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository repository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Company saveAll(Company employee) {

		return repository.save(employee);
	}

	@Override
	public Company findById(int empid) {
		return repository.findById(empid).get();
	}

	@Override
	public String updateEmpById(int empid,Employee employee) {

		 Employee byId = employeeRepository.findById(empid).get();
		 byId.setEmpname(employee.getEmpname());
		 employeeRepository.save(byId);
		return "updated";
	}

	@Override
	public String deleteById(int empid) {

		  employeeRepository.deleteById(empid);
		  return"deleted";
	}

	

	

	@Override
	public String findByName(String empname) {
		
	employeeRepository.findByempname(empname);
		return "get";


					
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	

	

}
