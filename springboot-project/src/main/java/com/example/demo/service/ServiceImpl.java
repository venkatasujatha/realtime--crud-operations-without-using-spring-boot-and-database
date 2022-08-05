package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.exception.NameNotFoundException;
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
	public Company findById(int empid) throws IdNotFoundException  {
		
		if(employeeRepository.existsById(empid))
		{
			return repository.findById(empid).get();

		}
		else {
			throw new IdNotFoundException();
		}
	}

	@Override
	public String updateEmpById(int empid,Employee employee) {

		 Employee byId = employeeRepository.findById(empid).get();
		 byId.setEmpname(employee.getEmpname());
		 employeeRepository.save(byId);
		return "updated";
	}

	@Override
	public String deleteById(int empid) throws IdNotFoundException {
		
		if(employeeRepository.existsById(empid))
		{

		   employeeRepository.deleteById(empid);
		}
		else
		{
			throw new IdNotFoundException();
		}
		
		return "";
		  
	}
	
	@Override
	public String findByName(String empname) throws NameNotFoundException {
		if(employeeRepository.equals(empname))
		{
			return employeeRepository.findByempname(empname);
		}
		else
		{
			throw new NameNotFoundException();
		}
							
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findEmployeeWithSorting(String field) {
		
		return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	@Override
	public Page<Employee> findEmployeeWithPagination(int offset, int pagesize) {
		 Page<Employee> findAll = employeeRepository.findAll(PageRequest.of(offset, pagesize));
		return findAll;
		
	}

	@Override
	public Page<Employee> findEmployeeWithPaginationAndSort(int offset, int pagesize, String field) {
		
		Page<Employee> findAll1=employeeRepository.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(field)));
		return findAll1;
	}

	
	

	

}
