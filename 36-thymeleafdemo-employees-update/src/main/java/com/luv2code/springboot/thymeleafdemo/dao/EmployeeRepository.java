package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

//@RepositoryRestResource(path="members") <- change rest api access name for employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// no need to write any code
	
	// add method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
