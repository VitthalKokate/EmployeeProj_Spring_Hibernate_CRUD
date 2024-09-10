package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	public List<Employee> getAllRec() {
		return employeeDao.getAllRec();
	}

	public Employee getRecBasedOnID(int id) {
		return employeeDao.getRecBasedOnID(id);
	}

	public void insertNewRecord(Employee employee) {
		employeeDao.insertNewRecord(employee);
		
	}

	public void updateRec(Employee employee) {
		employeeDao.updateRec(employee);
		
	}

	public void delRecBasedOnName(String name) {
		employeeDao.delRecBasedOnName(name);
		
	}

	public void delRec(int id) {
		employeeDao.delRec(id);
		
	}

}
