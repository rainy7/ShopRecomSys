package edu.sjtu.shop.recomSys.dao;

import edu.sjtu.shop.recomSys.main.HibernateSessionFactory;

import org.hibernate.Session;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}