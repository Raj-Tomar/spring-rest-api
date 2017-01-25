package com.raj.dao;

import java.util.List;

import com.raj.beans.CountryBean;

public interface WorldDbDao {

	/**
	 * @return
	 */
	public List<CountryBean> getAllCountry();
}
