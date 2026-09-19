package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDAO {
	
	int addEmployee(Employee employee);
	
	int deleteEmployee(int id);
	
	int updateEmployee(Employee employee);
	
	List<Employee>allEmployee();
	
}
