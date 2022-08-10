package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.catalina.connector.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;


import com.example.demo.exception.IdNotFoundException;
import com.example.demo.exception.NameNotFoundException;
import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.CompanyService;


@RestController
public class MainController {
	
//private static final  Logger logger=Logger.getLogger(MainController.class);

	@Autowired
	private CompanyService companyService;
	
  	
	//save
	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED, reason = "record is created")
	public ResponseEntity<?> saveEmp(@Valid @RequestBody Company employee) {

		Company saveAll = companyService.saveAll(employee);
		return ResponseEntity.status(201).body(saveAll);
	}

		//getall
	  @GetMapping("/getall") 
	 
	  public ResponseEntity<?> getAllEmployees()
	  {  
	  List<Employee> emplist = companyService.findAll();
	   return ResponseEntity.status(202).body(emplist);   
	  }
	 
	/*
	 * @GetMapping("/getall") public ResponseEntity<?> getAllDetails() {
	 * logger.info("");
	 * 
	 * List<Employee> responses = null; try { responses = companyService.findAll();
	 * } catch (Exception ex) {
	 * logger.error("There is an exception while fetching the data",ex); return new
	 * ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR); }
	 * logger.info("Fetching the data successfully"); return new
	 * ResponseEntity<>(responses, HttpStatus.OK); }
	 */	

	  //get by empid
	  
	@GetMapping("/get/{empid}")
	public Object getById(@PathVariable int empid) throws IdNotFoundException {
		//logger.info("get employee details");
		return companyService.findById(empid);
		
	}
	
	//get by name
	@GetMapping("/get1/{empname}")
	public String findByName(@PathVariable String empname) throws NameNotFoundException {
		companyService.findByName(empname);
		//logger.info("get employee details");
		return "get";
	}
	
	//update by id
	@PutMapping("/update/{empid}")
	
	public ResponseEntity<String> updateEmpById(@PathVariable int empid, @Valid @RequestBody Employee employee) {
		companyService.updateEmpById(empid, employee);
		return ResponseEntity.ok("valid");
	}
	
	//delete
	@DeleteMapping("/delete/{empid}")
	public String deleteById(@PathVariable int empid) throws IdNotFoundException {
		companyService.deleteById(empid);
		return "deleted";
	}
	
	//sorting
	@GetMapping("/{field}")
	public List<Employee> getEmployeeWithSort(@PathVariable String field) {
		List<Employee> allEmployees = companyService.findEmployeeWithSorting(field);
		return allEmployees;
	}
	
	//pagging
	@GetMapping("/pagination/{offset}/{pagesize}")
	public Page<Employee> getEmployeeWithPagination(@PathVariable int offset, @PathVariable int pagesize) {
		Page<Employee> allEmployees = companyService.findEmployeeWithPagination(offset, pagesize);
		return allEmployees;
	}
	
	//pagging with sort
	@GetMapping("/pagination/{offset}/{pagesize}/{field}")
	public Page<Employee> getEmployeeWithPaginationWithSort(@PathVariable int offset, @PathVariable int pagesize,
			@PathVariable String field) {

		Page<Employee> allEmp = companyService.findEmployeeWithPaginationAndSort(offset, pagesize, field);

		return allEmp;

	}
}
