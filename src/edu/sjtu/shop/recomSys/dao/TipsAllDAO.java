package edu.sjtu.shop.recomSys.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjtu.shop.recomSys.pojo.TipsAll;

/**
 * A data access object (DAO) providing persistence and search support for
 * TipsAll entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.sjtu.shop.recomSys.pojo.TipsAll
 * @author MyEclipse Persistence Tools
 */

public class TipsAllDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TipsAllDAO.class);
	// property constants
	public static final String VENUE_ID = "venueId";
	public static final String USER_ID = "userId";
	public static final String TEXT = "text";
	public static final String CREATED_TIME = "createdTime";
	public static final String TODO = "todo";
	public static final String DONE = "done";

	public void save(TipsAll transientInstance) {
		log.debug("saving TipsAll instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TipsAll persistentInstance) {
		log.debug("deleting TipsAll instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipsAll findById(java.math.BigDecimal id) {
		log.debug("getting TipsAll instance with id: " + id);
		try {
			TipsAll instance = (TipsAll) getSession().get(
					"edu.sjtu.shop.recomSys.pojo.TipsAll", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TipsAll instance) {
		log.debug("finding TipsAll instance by example");
		try {
			List results = getSession()
					.createCriteria("edu.sjtu.shop.recomSys.pojo.TipsAll")
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
		log.debug("finding TipsAll instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TipsAll as model where model."
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

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List findByCreatedTime(Object createdTime) {
		return findByProperty(CREATED_TIME, createdTime);
	}

	public List findByTodo(Object todo) {
		return findByProperty(TODO, todo);
	}

	public List findByDone(Object done) {
		return findByProperty(DONE, done);
	}

	public List findAll() {
		log.debug("finding all TipsAll instances");
		try {
			String queryString = "from TipsAll";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TipsAll merge(TipsAll detachedInstance) {
		log.debug("merging TipsAll instance");
		try {
			TipsAll result = (TipsAll) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TipsAll instance) {
		log.debug("attaching dirty TipsAll instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipsAll instance) {
		log.debug("attaching clean TipsAll instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}