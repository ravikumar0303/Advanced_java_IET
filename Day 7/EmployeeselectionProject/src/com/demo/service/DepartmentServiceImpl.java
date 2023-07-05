package com.demo.service;

import java.util.List;

import com.demo.beans.Department;
import com.demo.dao.DepartmentDao;
import com.demo.dao.DepartmentDaoImpl;

public class DepartmentServiceImpl implements DepartmentService {
     private DepartmentDao deptdao;

	public DepartmentServiceImpl() {
		super();
		this.deptdao = new DepartmentDaoImpl();
	}

	@Override
	public List<Department> getAllDepartment() {
		return deptdao.getAlldepartments();
	}
     
}
