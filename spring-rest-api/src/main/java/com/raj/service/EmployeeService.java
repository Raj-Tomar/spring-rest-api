package com.raj.service;

import org.springframework.stereotype.Service;

@Service
//@Scope(value = "prototype")
public interface EmployeeService {

	/**
	 * @param requestData
	 * @return
	 */
	public String saveOrUpdateEmployee(String requestData);
	/**
	 * @return
	 */
	public String getEmployeeList(String requestData);
	/**
	 * @param id
	 * @return
	 */
	public String getEmployeeById(String requestData);
	/**
	 * @param id
	 * @return
	 */
	public String deleteEmployee(String requestData);
	/**
	 * @param requestData
	 * @return
	 */
	public String saveOrUpdateDepartment(String requestData);
	/**
	 * @param requestData
	 * @return
	 */
	public String getAllDepartment(String requestData);
	
	/**
	 * @param requestData
	 * @return
	 */
	public String getAllDepartmentContact(String requestData);
	
}
