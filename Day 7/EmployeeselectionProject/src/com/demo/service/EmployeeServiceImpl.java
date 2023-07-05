package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
   private EmployeeDao empDao;
   

public EmployeeServiceImpl() {
	super();
	this.empDao =new EmployeeDaoImpl();
}

@Override
public List<Employee> getAllEmployees(int deptno) {
	return empDao.findAllEmployees(deptno);
}

@Override
public void closeConnection() {
	empDao.closeDBConnection();
	
}
   
}
