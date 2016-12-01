package com.raj.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raj.beans.CountryBean;
import com.raj.dao.WorldDbDao;

@Repository
public class WorldDbDaoImpl implements WorldDbDao{
	
	@Autowired
	private SessionFactory sessionFactoryWorld;
	
	private static Logger LOGGER = Logger.getLogger(WorldDbDaoImpl.class);
	
	@Override
	public List<CountryBean> getAllCountry() {

		Session session = null;
		List<CountryBean> list = new ArrayList<CountryBean>();
		try{
			session = sessionFactoryWorld.openSession();
			
			// Hibernate 5.2 Criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<CountryBean> criteria = builder.createQuery( CountryBean.class );
			Root<CountryBean> root = criteria.from( CountryBean.class );
			criteria.select( root );
			//criteria.where( builder.equal( root.get( CountryBean.name ), "John Doe" ) );

			list = session.createQuery( criteria ).getResultList();
			
			LOGGER.info("Total Countries: "+list.size());
			//Query<EmployeeBean> query = session.createQuery("From EmployeeBean");
			//list = query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	
	}

}
