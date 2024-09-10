package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
// Get All Records 
	@GetMapping("GetAllRecords")
	public List<Employee> getAllRec(){
		return employeeService.getAllRec();
	}
	
	// Get Records Based on ID
	@GetMapping("GetRecBasedID")
	public Employee getRecBasedOnID(@RequestParam int id) {
		return employeeService.getRecBasedOnID(id);
	}
	
	// Insert New Record 
	@PostMapping("InsertNewRec")
	public void insertNewRecord(@RequestBody Employee employee) {
		System.err.println(employee);
		employeeService.insertNewRecord(employee);
	}
	
	// Update Existing Record
	@PutMapping("UpdateRecord")
	public void updateRec(@RequestBody Employee employee) {
		employeeService.updateRec(employee);
	}
	
	
	// Delete Record Based on ID;
	@DeleteMapping("DelEmp")
	public void delRec(@RequestParam int id) {
		employeeService.delRec(id);
	}
	
	// Delete Records Based on Name
	@DeleteMapping("DeleteRecNm")
	public void delRecBasedOnName(@RequestParam String name) {
		employeeService.delRecBasedOnName(name);
	}

}
