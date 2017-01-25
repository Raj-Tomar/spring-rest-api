package com.raj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raj.beans.CountryBean;

@Service
public interface WorldDbService {

	
	/**
	 * @param requestData
	 * @return
	 */
	public String getAllCountry(String requestData);
	
	/**
	 * @param requestData
	 * @return
	 */
	public List<CountryBean> getAllCountry(CountryBean requestData);
}
