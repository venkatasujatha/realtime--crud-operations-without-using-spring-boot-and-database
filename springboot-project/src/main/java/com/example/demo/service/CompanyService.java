package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.exception.NameNotFoundException;
import com.example.demo.model.Company;
import com.example.demo.model.Employee;

public interface CompanyService {

	Company saveAll(Company employee);

	Company findById(int empid) throws IdNotFoundException    ;

	String updateEmpById(int empid,Employee employee);

	String  deleteById(int empid) throws IdNotFoundException;

	String findByName(String empname) throws NameNotFoundException;

	List<Employee> findAll();

	List<Employee> findEmployeeWithSorting(String field);

	Page<Employee> findEmployeeWithPagination(int offset, int pagesize);

	//Page<Employee> findEmployeeWithPaginationAndSort(int offset, int pagesize, String field);

	Page<Employee> findEmployeeWithPaginationAndSort(int offset, int pagesize, String field);

}
