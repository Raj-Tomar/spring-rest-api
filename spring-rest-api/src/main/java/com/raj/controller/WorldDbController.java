package com.raj.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raj.beans.CountryBean;
import com.raj.service.WorldDbService;

@RestController
public class WorldDbController {

	@Autowired
	WorldDbService worldDbServiceService;
	private static Logger logger = Logger.getLogger(WorldDbController.class);
	
	/**
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/getAllCountry", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getAllCountry(@RequestBody String requestData){
		logger.info("getAllCountry in controller");
		ResponseEntity<String> result = null;
		try {
			String status = worldDbServiceService.getAllCountry(requestData);
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
	@RequestMapping(value="/getCountries", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<CountryBean>> getAllCountry(@RequestBody CountryBean requestData){
		logger.info("getAllCountry in controller");
		ResponseEntity<List<CountryBean>> result = null;
		try {
			List<CountryBean> status = worldDbServiceService.getAllCountry(requestData);
			result = new ResponseEntity<List<CountryBean>>(status, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
}
