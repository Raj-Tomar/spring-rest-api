package com.raj.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raj.service.ChartAndGraphService;
import com.wordnik.swagger.annotations.Api;

@Api(value = "Chart And GraphController", description = "Returns Countries and Cities") // Swagger annotation
@RestController
public class ChartAndGraphController {

	@Autowired
	private ChartAndGraphService chartService;
	
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphController.class);
	
	@RequestMapping(value="/getAllCities", method=RequestMethod.POST)
	@ResponseBody
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
	
	@RequestMapping(value="/areaWiseCountries", method=RequestMethod.POST)
	@ResponseBody
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
	
	@RequestMapping(value="/getAllCountryCode", method=RequestMethod.POST)
	@ResponseBody
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
	
	@RequestMapping(value="/cityWisePopulation", method=RequestMethod.POST)
	@ResponseBody
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
	
	@RequestMapping(value="/getStateNames", method=RequestMethod.POST)
	@ResponseBody
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
	
	@RequestMapping(value="/stateWisePopulation", method=RequestMethod.POST)
	@ResponseBody
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
