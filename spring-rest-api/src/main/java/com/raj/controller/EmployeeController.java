package com.raj.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raj.service.EmployeeService;


@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	private static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@RequestMapping(value = "/testUrl", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> testUrl(@RequestBody String requestData, HttpServletRequest request){
		logger.info("testUrl");
		String str = "test";
		ResponseEntity<String> result = null;
		try {
			result = new ResponseEntity<String>(str, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/saveOrUpdateEmployee", method=RequestMethod.POST)
	public ResponseEntity<String> saveOrUpdateEmployee(@RequestBody String requestData){
		logger.info("saveOrUpdateEmployee in controller");
		ResponseEntity<String> result = null;
		try {
			String status = employeeService.saveOrUpdateEmployee(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/getAllEmployee", method=RequestMethod.POST)
	public ResponseEntity<String> getAllEmployee(@RequestBody String requestData){
		logger.info("getAllEmployee in controller");
		ResponseEntity<String> result = null;
		try {
			String status = employeeService.getEmployeeList(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/getEmployeeById", method=RequestMethod.POST)
	public ResponseEntity<String> getEmployeeById(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = employeeService.getEmployeeById(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/deleteEmployee", method=RequestMethod.POST)
	public ResponseEntity<String> deleteEmployee(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = employeeService.deleteEmployee(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/saveOrUpdateDepartment", method=RequestMethod.POST)
	public ResponseEntity<String> saveOrUpdateDepartment(@RequestBody String requestData){
		logger.info("saveOrUpdateDepartment in controller");
		ResponseEntity<String> result = null;
		try {
			String status = employeeService.saveOrUpdateDepartment(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
}
