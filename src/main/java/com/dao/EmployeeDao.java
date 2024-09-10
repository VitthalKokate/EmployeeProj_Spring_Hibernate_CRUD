package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Employee> getAllRec() {
		
		Session session = sessionFactory.openSession();
		
		List<Employee> employees ;
		
		employees = session.createQuery("FROM Employee", Employee.class ).getResultList();
		
		return employees;
	}

	public Employee getRecBasedOnID(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = session.load(Employee.class, id);
		return employee;
	}

	public void insertNewRecord(Employee employee) {
		Session session = sessionFactory.openSession();
		session.save(employee);
		session.beginTransaction().commit();
	}

	public void updateRec(Employee employee) {
		Session session = sessionFactory.openSession();
		session.update(employee);
		session.beginTransaction().commit();
		
	}

	public void delRecBasedOnName(String name) {
		
		Session session = sessionFactory.openSession();
		List<Employee>employees = session.createQuery("FROM Employee",Employee.class).getResultList();
		Employee emp = null ;
		for (Employee employee : employees) {
			
			if(employee.getName().equalsIgnoreCase(name))
				emp = employee;
		}
		
		if(emp!= null) {
			session.delete(emp);
			session.beginTransaction().commit();
		}
			
			
		}
	

	public void delRec(int id) {
		Session session = sessionFactory.openSession();
		Employee emp = session.load(Employee.class, id);
		session.delete(emp);
		session.beginTransaction().commit();
		
	}

}
