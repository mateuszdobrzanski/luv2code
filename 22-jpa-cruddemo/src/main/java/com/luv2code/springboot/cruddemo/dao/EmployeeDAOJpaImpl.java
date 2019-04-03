package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {	
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		// execute query and get results list
		List<Employee> employee = theQuery.getResultList();
		
		// return the results
		return employee;
	}

	@Override
	public Employee findById(int theId) {

		// get employee
		Employee theEeployee = entityManager.find(Employee.class, theId);
		
		//return employee
		return theEeployee;
	}

	@Override
	public void save(Employee theEmployee) {

		// save or update the employee
		// if id == 0 insert/save employee in otherwise update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		// update with id from db
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();

	}

}
