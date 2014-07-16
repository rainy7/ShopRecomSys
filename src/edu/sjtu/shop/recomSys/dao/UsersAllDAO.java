package edu.sjtu.shop.recomSys.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjtu.shop.recomSys.pojo.UsersAll;

/**
 * A data access object (DAO) providing persistence and search support for
 * UsersAll entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.sjtu.shop.recomSys.pojo.UsersAll
 * @author MyEclipse Persistence Tools
 */

public class UsersAllDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UsersAllDAO.class);
	// property constants
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String ICON = "icon";
	public static final String GENDER = "gender";
	public static final String USER_CITY = "userCity";

	public void save(UsersAll transientInstance) {
		log.debug("saving UsersAll instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UsersAll persistentInstance) {
		log.debug("deleting UsersAll instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UsersAll findById(java.lang.Long id) {
		log.debug("getting UsersAll instance with id: " + id);
		try {
			UsersAll instance = (UsersAll) getSession().get(
					"edu.sjtu.shop.recomSys.pojo.UsersAll", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByRange(long min, long max) {
		log.debug("finding all UsersAll instances");
		try {
			String queryString = "from UsersAll as model where model.userId >= ? and model.userId < ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setLong(0, min);
			queryObject.setLong(1, max);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	} 

	public List findByExample(UsersAll instance) {
		log.debug("finding UsersAll instance by example");
		try {
			List results = getSession()
					.createCriteria("edu.sjtu.shop.recomSys.pojo.UsersAll")
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
		log.debug("finding UsersAll instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UsersAll as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List findByIcon(Object icon) {
		return findByProperty(ICON, icon);
	}

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByUserCity(Object userCity) {
		return findByProperty(USER_CITY, userCity);
	}

	public List findAll() {
		log.debug("finding all UsersAll instances");
		try {
			String queryString = "from UsersAll";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UsersAll merge(UsersAll detachedInstance) {
		log.debug("merging UsersAll instance");
		try {
			UsersAll result = (UsersAll) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UsersAll instance) {
		log.debug("attaching dirty UsersAll instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UsersAll instance) {
		log.debug("attaching clean UsersAll instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}