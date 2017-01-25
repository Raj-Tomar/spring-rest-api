package com.raj.dao;

import java.util.List;

import com.raj.beans.CityBean;
import com.raj.dto.KeyValueDto;

public interface ChartAndGraphDao {

	/**
	 * @return
	 */
	public List<CityBean> getAllCities();
	
	/**
	 * @param requestData
	 * @return
	 */
	public List<KeyValueDto> areaWiseCountries(String requestData);

	/**
	 * @param requestData
	 * @return
	 */
	public List<String> getAllCountryCode(String requestData);
	
	/**
	 * @param countryCode
	 * @return
	 */
	public List<CityBean> cityWisePopulation(String countryCode);

	/**
	 * @param requestData
	 * @return
	 */
	public List<String> getStateNames(String requestData);

	/**
	 * @param stateName
	 * @return
	 */
	public List<CityBean> stateWisePopulation(String stateName);

	/**
	 * @return
	 */
	public List<CityBean> getPopulation();

}
