package com.raj.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raj.beans.CityBean;
import com.raj.dao.ChartAndGraphDao;
import com.raj.dto.KeyValueDto;

@Repository
public class ChartAndGraphDaoImpl implements ChartAndGraphDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphDaoImpl.class);
	
	@Override
	public List<CityBean> getAllCities() {
		Session session = null;
		List<CityBean> list = new ArrayList<CityBean>();
		try {
			session = sessionFactory.openSession();
			// Hibernate 5.2 Criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CityBean> criteria = builder.createQuery( CityBean.class );
			Root<CityBean> root = criteria.from( CityBean.class );
			criteria.select( root );
			list = session.createQuery( criteria ).getResultList();
			LOGGER.info("Total Cities: "+list.size());
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
			e.printStackTrace();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
	@Override
	public List<KeyValueDto> areaWiseCountries(String requestData) {
		List<KeyValueDto> list = new ArrayList<KeyValueDto>();
		try {
			list.add(new KeyValueDto("Russia", "17098242"));
			list.add(new KeyValueDto("Canada", "9984670"));
			list.add(new KeyValueDto("USA", "9826675"));
			list.add(new KeyValueDto("China", "9596961"));
			list.add(new KeyValueDto("Brazil", "8514877"));
			list.add(new KeyValueDto("Australia", "7741220"));
			list.add(new KeyValueDto("India", "3287263"));
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllCountryCode(String requestData) {
		Session session = null;
		List<String> list = new ArrayList<String>();
		try {
			session = sessionFactory.openSession();
			Query<String> query = session.createQuery("Select code From CountryBean");
			list = query.getResultList();
			LOGGER.info("Total Country Codes: "+list.size());
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityBean> cityWisePopulation(String countryCode) {
		Session session = null;
		List<CityBean> list = new ArrayList<CityBean>();
		try {
			session = sessionFactory.openSession();
			//Query<CityBean> query = session.createQuery("Select name, district, population From CityBean where countryCode=?");
			Query<CityBean> query = session.createQuery("From CityBean where countryCode=?");
			query.setParameter(0, countryCode);
			list = query.getResultList();;
			LOGGER.info("Total Cities In selected Country: "+list.size());
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<String> getStateNames(String requestData) {
		Session session = null;
		List<String> list = new ArrayList<String>();
		try {
			session = sessionFactory.openSession();
			Query<String> query = session.createQuery("Select distinct district From CityBean");
			//Query<String> query = session.createSQLQuery("SELECT DISTINCT CONVERT(district USING utf8) FROM city");
			list = query.getResultList();;
			LOGGER.info("Total District: "+list.size());
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		} finally {
			if(session.isOpen())
				session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityBean> stateWisePopulation(String stateName) {
		Session session = null;
		List<CityBean> list = new ArrayList<CityBean>();
		try {
			session = sessionFactory.openSession();
			//Query<CityBean> query = session.createQuery("Select name, district, population From CityBean where countryCode=?");
			Query<CityBean> query = session.createQuery("From CityBean where district=?");
			query.setParameter(0, stateName);
			list = query.getResultList();;
			LOGGER.info("Total Cities In Selected District: "+list.size());
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		} finally {
			if(session.isOpen())
				session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityBean> getPopulation() {
		Session session = null;
		List<CityBean> list = new ArrayList<CityBean>();
		try {
			session = sessionFactory.openSession();
			Query<CityBean> query = session.createQuery("From CityBean");
			list = query.getResultList();;
			LOGGER.info("Total Records: "+list.size());
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		} finally {
			if(session.isOpen())
				session.close();
		}
		return list;
	}

}
