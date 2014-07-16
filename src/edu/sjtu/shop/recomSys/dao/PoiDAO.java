package edu.sjtu.shop.recomSys.dao;

import edu.sjtu.shop.recomSys.pojo.Poi;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Poi entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see edu.sjtu.shop.recomSys.pojo.Poi
  * @author MyEclipse Persistence Tools 
 */

public class PoiDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PoiDAO.class);
		//property constants
	public static final String POINT_ID = "pointId";



    
    public void save(Poi transientInstance) {
        log.debug("saving Poi instance");
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
    
	public void delete(Poi persistentInstance) {
        log.debug("deleting Poi instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Poi findById(Long id) {
        log.debug("getting Poi instance with id: " + id);
        try {
            Poi instance = (Poi) getSession()
                    .get("edu.sjtu.shop.recomSys.pojo.Poi", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Poi instance) {
        log.debug("finding Poi instance by example");
        try {
            List results = getSession()
                    .createCriteria("edu.sjtu.shop.recomSys.pojo.Poi")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Poi instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Poi as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPointId(Object pointId
	) {
		return findByProperty(POINT_ID, pointId
		);
	}
	

	public List findAll() {
		log.debug("finding all Poi instances");
		try {
			String queryString = "from Poi";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Poi merge(Poi detachedInstance) {
        log.debug("merging Poi instance");
        try {
            Poi result = (Poi) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Poi instance) {
        log.debug("attaching dirty Poi instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Poi instance) {
        log.debug("attaching clean Poi instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}