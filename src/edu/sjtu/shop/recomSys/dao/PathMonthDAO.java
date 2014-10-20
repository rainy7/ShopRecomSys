package edu.sjtu.shop.recomSys.dao;

import edu.sjtu.shop.recomSys.pojo.Path;
import edu.sjtu.shop.recomSys.pojo.PathMonth;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * PathMonth entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.sjtu.shop.recomSys.pojo.PathMonth
 * @author MyEclipse Persistence Tools
 */

public class PathMonthDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PathMonthDAO.class);

	// property constants

	public void save(PathMonth transientInstance) {
		log.debug("saving PathMonth instance");
		Transaction tran=getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		tran.commit();
		getSession().close();
	}

	public void delete(PathMonth persistentInstance) {
		log.debug("deleting PathMonth instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PathMonth findById(java.math.BigDecimal id) {
		log.debug("getting PathMonth instance with id: " + id);
		try {
			PathMonth instance = (PathMonth) getSession().get(
					"edu.sjtu.shop.recomSys.pojo.PathMonth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PathMonth instance) {
		log.debug("finding PathMonth instance by example");
		try {
			List results = getSession()
					.createCriteria("edu.sjtu.shop.recomSys.pojo.PathMonth")
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
		log.debug("finding PathMonth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PathMonth as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<PathMonth> findByUserId(Long userId) {
		try {
			String queryString = "from PathMonth as model where model.usersAll.userId = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setLong(0, userId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all PathMonth instances");
		try {
			String queryString = "from PathMonth";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PathMonth merge(PathMonth detachedInstance) {
		log.debug("merging PathMonth instance");
		try {
			PathMonth result = (PathMonth) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PathMonth instance) {
		log.debug("attaching dirty PathMonth instance");
		Transaction tran=getSession().beginTransaction();
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		tran.commit();
		getSession().flush();
		getSession().close();
	}

	public void attachClean(PathMonth instance) {
		log.debug("attaching clean PathMonth instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}