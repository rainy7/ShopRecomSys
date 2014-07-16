package edu.sjtu.shop.recomSys.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjtu.shop.recomSys.pojo.VenueNyc;

/**
 * A data access object (DAO) providing persistence and search support for
 * VenueNyc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.sjtu.shop.recomSys.pojo.VenueNyc
 * @author MyEclipse Persistence Tools
 */

public class VenueNycDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(VenueNycDAO.class);
	// property constants
	public static final String VENUE_NAME = "venueName";
	public static final String LA = "la";
	public static final String LO = "lo";
	public static final String ADDRESS = "address";
	public static final String VENUE_CITY = "venueCity";
	public static final String STATE = "state";
	public static final String CHECKIN_NUM = "checkinNum";
	public static final String CHECKIN_USER = "checkinUser";
	public static final String CURRENT_USER = "currentUser";
	public static final String TODO = "todo";
	public static final String CATEGORY_NUM = "categoryNum";

	public void save(VenueNyc transientInstance) {
		log.debug("saving VenueNyc instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VenueNyc persistentInstance) {
		log.debug("deleting VenueNyc instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VenueNyc findById(java.lang.String id) {
		log.debug("getting VenueNyc instance with id: " + id);
		try {
			VenueNyc instance = (VenueNyc) getSession().get(
					"edu.sjtu.shop.recomSys.pojo.VenueNyc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VenueNyc instance) {
		log.debug("finding VenueNyc instance by example");
		try {
			List results = getSession()
					.createCriteria("edu.sjtu.shop.recomSys.pojo.VenueNyc")
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
		log.debug("finding VenueNyc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VenueNyc as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVenueName(Object venueName) {
		return findByProperty(VENUE_NAME, venueName);
	}

	public List findByLa(Object la) {
		return findByProperty(LA, la);
	}

	public List findByLo(Object lo) {
		return findByProperty(LO, lo);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByVenueCity(Object venueCity) {
		return findByProperty(VENUE_CITY, venueCity);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByCheckinNum(Object checkinNum) {
		return findByProperty(CHECKIN_NUM, checkinNum);
	}

	public List findByCheckinUser(Object checkinUser) {
		return findByProperty(CHECKIN_USER, checkinUser);
	}

	public List findByCurrentUser(Object currentUser) {
		return findByProperty(CURRENT_USER, currentUser);
	}

	public List findByTodo(Object todo) {
		return findByProperty(TODO, todo);
	}

	public List findByCategoryNum(Object categoryNum) {
		return findByProperty(CATEGORY_NUM, categoryNum);
	}

	public List findAll() {
		log.debug("finding all VenueNyc instances");
		try {
			String queryString = "from VenueNyc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VenueNyc merge(VenueNyc detachedInstance) {
		log.debug("merging VenueNyc instance");
		try {
			VenueNyc result = (VenueNyc) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VenueNyc instance) {
		log.debug("attaching dirty VenueNyc instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VenueNyc instance) {
		log.debug("attaching clean VenueNyc instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}