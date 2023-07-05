package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees(int deptno);

	void closeConnection();

}
