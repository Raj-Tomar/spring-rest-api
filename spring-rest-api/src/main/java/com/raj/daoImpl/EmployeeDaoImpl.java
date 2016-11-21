package com.raj.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raj.beans.DepartmentBean;
import com.raj.beans.DeptContactDetail;
import com.raj.beans.EmployeeBean;
import com.raj.dao.EmployeeDao;

@Repository
//@Scope(value = "prototype")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public String saveOrUpdateEmployee(EmployeeBean bean) {
		String status = "0";
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			TransactionStatus transactionStatus = tx.getStatus();
			if(null == bean.getId()){
				session.save(bean);
				if(!transactionStatus.equals(TransactionStatus.COMMITTED )){
					tx.commit();
					status = "1";
			    }
				LOGGER.info("Employee Save Status: "+status);
			}else{
				session.update(bean);
				if(!transactionStatus.equals(TransactionStatus.COMMITTED )){
					tx.commit();
					status = "1";
			    }
				LOGGER.info("Employee Update Status: "+status);
			}
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return status;
	}

	@Override
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public List<EmployeeBean> getEmployeeList() {
		Session session = null;
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		try{
			session = sessionFactory.openSession();
			
			// Hibernate 5.2 Criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<EmployeeBean> criteria = builder.createQuery( EmployeeBean.class );
			Root<EmployeeBean> root = criteria.from( EmployeeBean.class );
			criteria.select( root );
			//criteria.where( builder.equal( root.get( EmployeeBean.name ), "John Doe" ) );

			list = session.createQuery( criteria ).getResultList();
			
			LOGGER.info("Total Employees: "+list.size());
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

	@Override
	public EmployeeBean getEmployeeById(Integer id) {
		Session session = null;
		EmployeeBean bean = null;
		try {
			session = sessionFactory.openSession();
			bean = session.get(EmployeeBean.class, id);
		} 
		catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return bean;
	}

	@Override
	public String deleteEmployee(Integer id) {
		Session session = null;
		Transaction tx = null;
		String status = "0";
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			EmployeeBean bean = session.get(EmployeeBean.class, id);
			if(null != bean){
				session.delete(bean);
				tx.commit();
				status = "1";
			}
		} catch (Exception e) {
			tx.rollback();
			LOGGER.error("Exception: "+e.getMessage());
		}
		return status;
	}

	@Override
	public String saveOrUpdateDepartment(DepartmentBean bean) {
		String status = "0";
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			TransactionStatus transactionStatus = tx.getStatus();
			if(null == bean.getId()){
				session.save(bean);
				if(!transactionStatus.equals(TransactionStatus.COMMITTED )){
					tx.commit();
					status = "1";
			    }
				LOGGER.info("Department Save Status: "+status);
			}else{
				session.update(bean);
				if(!transactionStatus.equals(TransactionStatus.COMMITTED )){
					tx.commit();
					status = "1";
			    }
				LOGGER.info("Department Update Status: "+status);
			}
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return status;
	
	}

	@Override
	public List<DepartmentBean> getAllDepartment() {
		Session session = null;
		List<DepartmentBean> list = new ArrayList<DepartmentBean>();
		try {
			session = sessionFactory.openSession();
			// Hibernate 5.2 Criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DepartmentBean> criteria = builder.createQuery( DepartmentBean.class );
			Root<DepartmentBean> root = criteria.from( DepartmentBean.class );
			criteria.select( root );
			list = session.createQuery( criteria ).getResultList();
			LOGGER.info("Total Employees: "+list.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<DeptContactDetail> getAllDepartmentContact() {
		Session session = null;
		List<DeptContactDetail> list = new ArrayList<DeptContactDetail>();
		try {
			session = sessionFactory.openSession();
			// Hibernate 5.2 Criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DeptContactDetail> criteria = builder.createQuery( DeptContactDetail.class );
			Root<DeptContactDetail> root = criteria.from( DeptContactDetail.class );
			criteria.select( root );
			list = session.createQuery( criteria ).getResultList();
			LOGGER.info("Total Employees: "+list.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

}
