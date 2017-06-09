package com.raj.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.raj.beans.DepartmentBean;
import com.raj.beans.DeptContactDetail;
import com.raj.beans.EmployeeBean;
import com.raj.dao.EmployeeDao;
import com.raj.dto.EmpDto;
import com.raj.service.EmployeeService;

@Service
//@Scope(value = "prototype")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Override
	public String saveOrUpdateEmployee(String requestData) {
		logger.info("saveOrUpdateEmployee in ServiceImpl");
		JSONObject requestJson = null;
		JSONObject responseJson = null;
		Gson gson = null;
		try {
			requestJson = new JSONObject(requestData);
			JSONObject jObj = requestJson.getJSONObject("requestData");
			gson = new Gson();
			EmployeeBean bean = gson.fromJson(jObj.get("emp").toString(), EmployeeBean.class);
			String status = employeeDao.saveOrUpdateEmployee(bean);
			responseJson = new JSONObject();
			responseJson.put("status", status);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return responseJson.toString();
	}

	@Override
	public String getEmployeeList(String requestData) {
		String status = "0";
		JSONObject responseJson = null;
		List<EmployeeBean> list = null;
		try {
			list = employeeDao.getEmployeeList();
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status",status);
				responseJson.put("empList",list);
			}
			else{
				responseJson.put("status",status);
			}
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return responseJson.toString();
	}

	@Override
	public String getEmployeeById(String requestData) {
		String status = "0";
		JSONObject requestJson = null;
		JSONObject responseJson = null;
		try {
			logger.info(requestData);
			requestJson = new JSONObject(requestData);
			JSONObject jObj = requestJson.getJSONObject("requestData");
			String empId = jObj.get("empId").toString();
			Integer id = Integer.parseInt(empId);
			EmployeeBean bean = employeeDao.getEmployeeById(id);
			responseJson = new JSONObject();
			if(null != bean){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("emp", new JSONObject(bean));
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return responseJson.toString();
	}

	@Override
	public String deleteEmployee(String requestData) {
		JSONObject requestJson = null;
		JSONObject responseJson = null;
		try {
			logger.info("deleteEmployee: "+requestData);
			requestJson = new JSONObject(requestData);
			JSONObject jObj = requestJson.getJSONObject("requestData");
			String empId = jObj.get("empId").toString();
			Integer id = Integer.parseInt(empId);
			String status = employeeDao.deleteEmployee(id);
			responseJson = new JSONObject();
			responseJson.put("status", status);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return responseJson.toString();
	}

	@Override
	public String saveOrUpdateDepartment(String requestData) {
		logger.info("saveOrUpdateDepartment in ServiceImpl");
		JSONObject requestJson = null;
		JSONObject responseJson = null;
		Gson gson = null;
		try {
			requestJson = new JSONObject(requestData);
			JSONObject jObj = requestJson.getJSONObject("requestData");
			gson = new Gson();
			DepartmentBean bean = gson.fromJson(jObj.get("dept").toString(), DepartmentBean.class);
			String status = employeeDao.saveOrUpdateDepartment(bean);
			responseJson = new JSONObject();
			responseJson.put("status", status);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return responseJson.toString();
	}

	@Override
	public String getAllDepartment(String requestData) {
		String status = "0";
		JSONObject responseJson = null;
		List<DepartmentBean> list = null;
		try {
			list = employeeDao.getAllDepartment();
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status",status);
				responseJson.put("deptList",list);
			}
			else{
				responseJson.put("status",status);
			}
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return responseJson.toString();
	}

	@Override
	public String getAllDepartmentContact(String requestData) {
		String status = "0";
		JSONObject responseJson = null;
		List<DeptContactDetail> list = null;
		try {
			list = employeeDao.getAllDepartmentContact();
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status",status);
				responseJson.put("deptContactList",list);
			}
			else{
				responseJson.put("status",status);
			}
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return responseJson.toString();
	}

	@Override
	public String getEmployeeAndDeptDetails(String requestData) {
		String status = "0";
		JSONObject responseJson = null;
		List<EmpDto> list = null;
		try {
			list = employeeDao.getEmployeeAndDeptDetails();
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status",status);
				responseJson.put("empDeptList",list);
			}
			else{
				responseJson.put("status",status);
			}
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return responseJson.toString();
	}

}
