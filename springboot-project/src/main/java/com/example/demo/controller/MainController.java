package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
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


import com.example.demo.exception.Exception;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.service.CompanyService;

@RestController
public class MainController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED, reason = "record is created")

	public ResponseEntity<?> saveEmp(@Valid @RequestBody Company employee)
	{
		
			
			  Company saveAll = companyService.saveAll(employee);
			
			return  ResponseEntity.status(201).body(saveAll);
			
		
	}
	@GetMapping("/getall")
	
	public ResponseEntity<?> getAllEmployees()
	{
		List<Employee> emplist= companyService.findAll();
		return ResponseEntity.status(202).body(emplist);
		 
	}
	
	@GetMapping("/get/{empid}")
	public Object getById(@PathVariable int empid)
	{
		return companyService.findById(empid);
	}
	@GetMapping("/get1/{empname}")
	public String findByName(@PathVariable String empname)
	{
		companyService.findByName(empname);
		return "get";
	}
	
	@PutMapping("/update/{empid}")
	public ResponseEntity<String> updateEmpById(@PathVariable int empid, @Valid @RequestBody Employee employee)
	{
		companyService.updateEmpById(empid,employee);
		return ResponseEntity.ok("valid");
	}
	@DeleteMapping("/delete/{empid}")
	public String deleteById(@PathVariable int empid)
	{
		  companyService.deleteById(empid);
		  return "deleted";
	}
	
	//public ResponseEntity<String>
}
