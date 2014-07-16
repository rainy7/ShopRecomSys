package edu.sjtu.shop.recomSys.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjtu.shop.recomSys.pojo.VeNyc;

/**
 * A data access object (DAO) providing persistence and search support for VeNyc
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see edu.sjtu.shop.recomSys.pojo.VeNyc
 * @author MyEclipse Persistence Tools
 */

public class VeNycDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(VeNycDAO.class);
	// property constants
	public static final String VENUE_ID = "venueId";
	public static final String CATEGORY_ID = "categoryId";

	public void save(VeNyc transientInstance) {
		log.debug("saving VeNyc instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VeNyc persistentInstance) {
		log.debug("deleting VeNyc instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VeNyc findById(java.math.BigDecimal id) {
		log.debug("getting VeNyc instance with id: " + id);
		try {
			VeNyc instance = (VeNyc) getSession().get(
					"edu.sjtu.shop.recomSys.pojo.VeNyc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VeNyc instance) {
		log.debug("finding VeNyc instance by example");
		try {
			List results = getSession()
					.createCriteria("edu.sjtu.shop.recomSys.pojo.VeNyc")
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
		log.debug("finding VeNyc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VeNyc as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVenueId(Object venueId) {
		return findByProperty(VENUE_ID, venueId);
	}

	public List findByCategoryId(Object categoryId) {
		return findByProperty(CATEGORY_ID, categoryId);
	}

	public List findAll() {
		log.debug("finding all VeNyc instances");
		try {
			String queryString = "from VeNyc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VeNyc merge(VeNyc detachedInstance) {
		log.debug("merging VeNyc instance");
		try {
			VeNyc result = (VeNyc) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VeNyc instance) {
		log.debug("attaching dirty VeNyc instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VeNyc instance) {
		log.debug("attaching clean VeNyc instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}