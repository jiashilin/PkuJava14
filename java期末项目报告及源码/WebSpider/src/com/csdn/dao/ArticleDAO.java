package com.csdn.dao;


import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Article entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Article
  * @author MyEclipse Persistence Tools 
 */
public class ArticleDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ArticleDAO.class);
		//property constants
	public static final String TITLE = "title";
	public static final String VIEW = "view";
	public static final String AUTHOR = "author";
	public static final String CONTENT = "content";
	public static final String TAG = "tag";



    
    public void save(Article transientInstance) {
        log.debug("saving Article instance");
        Transaction transaction= getSession().beginTransaction(); 
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
            System.out.println("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            System.out.println("save failed");
            throw re;
        }
        transaction.commit(); 
        getSession().flush();  
        getSession().close(); 
    }
    
	public void delete(Article persistentInstance) {
        log.debug("deleting Article instance");
        Transaction transaction= getSession().beginTransaction(); 
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
        transaction.commit(); 
        getSession().flush();  
        getSession().close(); 
    }
    
    public Article findById( java.lang.Integer id) {
        log.debug("getting Article instance with id: " + id);
        
        try {
            Article instance = (Article) getSession().get("Article", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Article instance) {
        log.debug("finding Article instance by example");
        try {
            List results = getSession()
                    .createCriteria("Article")
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
      log.debug("finding Article instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Article as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 queryObject.setFirstResult(0);   //从第0条开始
	      queryObject.setMaxResults(10);//一共取20条
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}
    public List findBySearch(String searchText) {
        log.debug("finding Article instance with searchText: " + searchText);
        try {
//           String queryString = "from Article as model where model." 
//           						+ propertyName + "= ?";
        	 String queryString = "from Article as a where a.title like ? OR a.tag LIKE ? OR a.content like ?" ;
						
          Query queryObject = getSession().createQuery(queryString);
  		queryObject.setString(0, "%" +searchText+"%" );
  		queryObject.setString(1, "%" +searchText+"%");
  		queryObject.setString(2, "%" +searchText+"%");
  		queryObject.setFirstResult(0);   //从第0条开始
        queryObject.setMaxResults(10);//一共取20条
  		 return queryObject.list();
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
    
    public List findByClass(String searchText) {
        log.debug("finding Article instance with searchText: " + searchText);
        try {
//           String queryString = "from Article as model where model." 
//           						+ propertyName + "= ?";
        	 String queryString = "from Article as a where a.title like ? OR a.tag LIKE ? AND a.content like ?" ;
						
          Query queryObject = getSession().createQuery(queryString);
  		queryObject.setString(0, "%" +searchText+"%" );
  		queryObject.setString(1, "%" +searchText+"%");
  		queryObject.setString(2, "%" +searchText+"%");
  	  queryObject.setFirstResult(0);   //从第0条开始
      queryObject.setMaxResults(10);//一共取20条
  		 return queryObject.list();
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
    
    public List findByS(String searchText) {
        log.debug("finding Article instance with searchText: " + searchText);
        try {
//           String queryString = "from Article as model where model." 
//           						+ propertyName + "= ?";
        	 String queryString = "from Article as a where a.title like ? OR a.tag LIKE ? AND a.content like ?" ;
						
          Query queryObject = getSession().createQuery(queryString);
  		queryObject.setString(0, "%" +searchText+"%" );
  		queryObject.setString(1, "%" +searchText+"%");
  		queryObject.setString(2, "%" +searchText+"%");
  		 return queryObject.list();
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
    
    public Article findByMax() {
        log.debug("finding Article instance with searchText: ");
        try {
//           String queryString = "from Article as model where model." 
//           						+ propertyName + "= ?";
        	 String queryString = "from Article as a where a.view=(select max(b.view) from Article as b)" ;
						
          Query queryObject = getSession().createQuery(queryString);
  		 return (Article) queryObject.list().get(0);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
	public List findByTitle(Object title
	) {
		return findByProperty(TITLE, title
		);
	}
	
	public List findByView(Object view
	) {
		return findByProperty(VIEW, view
		);
	}
	
	public List findByAuthor(Object author
	) {
		return findByProperty(AUTHOR, author
		);
	}
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List findByTag(Object tag
	) {
		return findByProperty(TAG, tag
		);
	}
	

	public List findAll() {
		log.debug("finding all Article instances");
		try {
			String queryString = "from Article";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findFirst() {
		log.debug("finding all Article instances");
		try {
			String queryString = "from Article";
	         Query queryObject = getSession().createQuery(queryString);
	         queryObject.setFirstResult(0);   //从第0条开始
	         queryObject.setMaxResults(20);//一共取20条
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public Long findCount() {
		try {
			//String queryString = "select count(*) from Article";
			 Long count = (Long) getSession().createQuery
					 ("select count(*) from Article").uniqueResult();
	        // Query queryObject = getSession().createQuery(queryString);
			 return count;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public Long findCountFrom(String str) {
		try {
			//String queryString = "select count(*) from Article";
			 Long count = (Long) getSession().createQuery
					 ("select count(*) from Article a where a.titlt like "+str+" or a.tag like " +str).uniqueResult();
	        // Query queryObject = getSession().createQuery(queryString);
			 return count;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Article merge(Article detachedInstance) {
        log.debug("merging Article instance");
        try {
            Article result = (Article) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Article instance) {
        log.debug("attaching dirty Article instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Article instance) {
        log.debug("attaching clean Article instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}