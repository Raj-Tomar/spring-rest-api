package com.raj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.raj.beans.CountryBean;

@Repository
public interface WorldDbDao {

	/**
	 * @return
	 */
	public List<CountryBean> getAllCountry();
}
