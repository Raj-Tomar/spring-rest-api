package com.raj.service;

import org.springframework.stereotype.Service;

@Service
public interface WorldDbService {

	
	/**
	 * @param requestData
	 * @return
	 */
	public String getAllCountry(String requestData);
}
