package com.raj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.raj.beans.DepartmentBean;
import com.raj.beans.EmployeeBean;

@Repository
//@Scope(value = "prototype")
public interface EmployeeDao {

	/**
	 * @param bean
	 * @return
	 */
	public String saveOrUpdateEmployee(EmployeeBean bean);
	/**
	 * @return
	 */
	public List<EmployeeBean> getEmployeeList();
	
	/**
	 * @param id
	 * @return
	 */
	public EmployeeBean getEmployeeById(Integer id);
	/**
	 * @param id
	 * @return
	 */
	public String deleteEmployee(Integer id);
	/**
	 * @param bean
	 * @return
	 */
	public String saveOrUpdateDepartment(DepartmentBean bean);
	
}
