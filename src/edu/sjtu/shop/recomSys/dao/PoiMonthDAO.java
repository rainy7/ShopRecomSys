package edu.sjtu.shop.recomSys.dao;

import edu.sjtu.shop.recomSys.pojo.PoiMonth;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * PoiMonth entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.sjtu.shop.recomSys.pojo.PoiMonth
 * @author MyEclipse Persistence Tools
 */

public class PoiMonthDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PoiMonthDAO.class);
	// property constants
	public static final String POINT_ID = "pointId";
	public static final String DATETIME = "datetime";

	public void save(PoiMonth transientInstance) {
		log.debug("saving PoiMonth instance");
		Transaction tran=getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		tran.commit();
        getSession().flush(); 
        getSession().close();
	}

	public void delete(PoiMonth persistentInstance) {
		log.debug("deleting PoiMonth instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PoiMonth findById(java.math.BigDecimal id) {
		log.debug("getting PoiMonth instance with id: " + id);
		try {
			PoiMonth instance = (PoiMonth) getSession().get(
					"edu.sjtu.shop.recomSys.pojo.PoiMonth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PoiMonth instance) {
		log.debug("finding PoiMonth instance by example");
		try {
			List results = getSession()
					.createCriteria("edu.sjtu.shop.recomSys.pojo.PoiMonth")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PoiMonth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PoiMonth as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPointId(Object pointId) {
		return findByProperty(POINT_ID, pointId);
	}

	public List findByDatetime(Object datetime) {
		return findByProperty(DATETIME, datetime);
	}

	public List findAll() {
		log.debug("finding all PoiMonth instances");
		try {
			String queryString = "from PoiMonth";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PoiMonth merge(PoiMonth detachedInstance) {
		log.debug("merging PoiMonth instance");
		try {
			PoiMonth result = (PoiMonth) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PoiMonth instance) {
		log.debug("attaching dirty PoiMonth instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PoiMonth instance) {
		log.debug("attaching clean PoiMonth instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}