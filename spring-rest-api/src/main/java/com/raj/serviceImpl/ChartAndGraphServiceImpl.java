package com.raj.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.beans.CityBean;
import com.raj.dao.ChartAndGraphDao;
import com.raj.dto.KeyValueDto;
import com.raj.service.ChartAndGraphService;

@Service
public class ChartAndGraphServiceImpl implements ChartAndGraphService{
	
	@Autowired
	private ChartAndGraphDao chartDao;
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphServiceImpl.class);

	@Override
	public String getAllCities(String requestData) {
		String status = "0";
		List<CityBean> list = null;
		JSONObject responseJson = null;
		try {
			list = chartDao.getAllCities();
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("cities", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}
	
	
	@Override
	public String areaWiseCountries(String requestData) {
		String status = "0";
		List<KeyValueDto> list = null;
		JSONObject responseJson = null;
		try {
			JSONObject requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			list = chartDao.areaWiseCountries(requestData);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("keyValue", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}
	
	@Override
	public String getAllCountryCode(String requestData) {
		String status = "0";
		List<String> list = null;
		JSONObject responseJson = null;
		try {
			JSONObject requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			list = chartDao.getAllCountryCode(requestData);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("countryCode", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

	@Override
	public String cityWisePopulation(String requestData) {
		String status = "0";
		List<CityBean> list = null;
		JSONObject responseJson = null;
		try {
			JSONObject requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			JSONObject jObj = requestJson.getJSONObject("requestData");
			String countryCode = jObj.getString("countryCode");
			list = chartDao.cityWisePopulation(countryCode);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("cityPopulation", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

	@Override
	public String getStateNames(String requestData) {
		String status = "0";
		List<String> list = null;
		JSONObject responseJson = null;
		try {
			JSONObject requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			list = chartDao.getStateNames(requestData);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("stateNames", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

	@Override
	public String stateWisePopulation(String requestData) {
		String status = "0";
		List<CityBean> list = null;
		JSONObject responseJson = null;
		try {
			JSONObject requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			JSONObject jObj = requestJson.getJSONObject("requestData");
			String stateName = jObj.getString("stateName");
			list = chartDao.stateWisePopulation(stateName);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("statePopulation", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}


	@Override
	public String getPopulation(String requestData) {
		String status = "0";
		List<CityBean> list = null;
		JSONObject responseJson = null;
		try {
			JSONObject requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			list = chartDao.getPopulation();
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("population", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

}
