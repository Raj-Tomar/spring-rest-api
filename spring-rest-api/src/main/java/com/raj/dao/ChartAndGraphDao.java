package com.raj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.raj.beans.CityBean;
import com.raj.dto.KeyValueDto;

@Repository
//@Scope(value = "prototype")
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
