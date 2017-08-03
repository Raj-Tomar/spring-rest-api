package com.raj.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.raj.service.EmployeeService;

@Service
public class EmployeeServiceImpl2 implements EmployeeService{

	private static Logger logger = Logger.getLogger(EmployeeServiceImpl2.class);
	
	@Override
	public String saveOrUpdateEmployee(String requestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmployeeList(String requestData) {
		logger.info("getEmployeeList");
		return null;
	}

	@Override
	public String getEmployeeById(String requestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(String requestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveOrUpdateDepartment(String requestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllDepartment(String requestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllDepartmentContact(String requestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmployeeAndDeptDetails(String requestData) {
		// TODO Auto-generated method stub
		return null;
	}

}
