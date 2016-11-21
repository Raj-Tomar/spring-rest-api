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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	private static Logger logger = Logger.getLogger(EmployeeController.class);
	
	/**
	 * @param requestData
	 * @param request
	 * @return
	 */
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

	/**
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/saveOrUpdateEmployee", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
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

	/**
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/getAllEmployee", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
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

	/**
	 * @param requestData
	 * @return
	 */
	@ApiOperation(value = "getEmployeeById", notes = "This api fetches the employee details based on employee id.")
	@RequestMapping(value="/getEmployeeById", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getEmployeeById(@ApiParam(value = "Find Employee by ID", required = true, 
			examples = @Example(value = { @ExampleProperty(value = "{\"account\":\"aaa\",\"password\":\"123\"}")})) @RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = employeeService.getEmployeeById(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}

	/**
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/deleteEmployee", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
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

	/**
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/saveOrUpdateDepartment", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
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
