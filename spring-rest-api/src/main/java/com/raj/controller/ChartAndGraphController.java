package com.raj.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raj.service.ChartAndGraphService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ChartAndGraphController {

	@Autowired
	private ChartAndGraphService chartService;
	
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphController.class);
	
	@ApiOperation(value = "getAllCities", nickname = "Get All Cities")
	@RequestMapping(value="/getAllCities", method=RequestMethod.POST)
	public ResponseEntity<String> getAllCities(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = chartService.getAllCities(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@ApiOperation(value = "areaWiseCountries", nickname = "Area Wise Countries")
	@RequestMapping(value="/areaWiseCountries", method=RequestMethod.POST)
	public ResponseEntity<String> areaWiseCountries(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = chartService.areaWiseCountries(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@ApiOperation(value = "getAllCountryCode", nickname = "Get All Country Code")
	@RequestMapping(value="/getAllCountryCode", method=RequestMethod.POST)
	public ResponseEntity<String> getAllCountryCode(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = chartService.getAllCountryCode(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@ApiOperation(value = "cityWisePopulation", nickname = "City Wise Population")
	@RequestMapping(value="/cityWisePopulation", method=RequestMethod.POST)
	public ResponseEntity<String> cityWisePopulation(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = chartService.cityWisePopulation(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@ApiOperation(value = "getStateNames", nickname = "Get State Names")
	@RequestMapping(value="/getStateNames", method=RequestMethod.POST)
	public ResponseEntity<String> getStateNames(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = chartService.getStateNames(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@ApiOperation(value = "stateWisePopulation", nickname = "Dtate Wise Population")
	@RequestMapping(value="/stateWisePopulation", method=RequestMethod.POST)
	public ResponseEntity<String> stateWisePopulation(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = chartService.stateWisePopulation(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return result;
	}
}
