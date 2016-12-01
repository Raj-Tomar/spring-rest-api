package com.raj.service;

import org.springframework.stereotype.Service;

@Service
//@Scope(value = "prototype")
public interface ChartAndGraphService {

	/**
	 * @param requestData
	 * @return
	 */
	public String getAllCities(String requestData);
	
	/**
	 * @param requestData
	 * @return
	 */
	public String areaWiseCountries(String requestData);
	
	/**
	 * @param requestData
	 * @return
	 */
	public String getAllCountryCode(String requestData);

	/**
	 * @param requestData
	 * @return
	 */
	public String cityWisePopulation(String requestData);

	/**
	 * @param requestData
	 * @return
	 */
	public String getStateNames(String requestData);

	/**
	 * @param requestData
	 * @return
	 */
	public String stateWisePopulation(String requestData);

	/**
	 * @param requestData
	 * @return
	 */
	public String getPopulation(String requestData);
}
