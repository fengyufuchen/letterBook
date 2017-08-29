package com.sachin.bl.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sachin.bl.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {
	@Resource(name = "hibernateTemplate")
	HibernateTemplate hibernateTemplate;

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return this.sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		if (this.hibernateTemplate == null) {
			this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	public boolean saveObject(Object o) {
		try {

			this.getHibernateTemplate().save(o);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean deleteObject(Object object) {

		try {
			this.getHibernateTemplate().delete(object);
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public boolean updateObject(Object object) {

		try {
			this.getHibernateTemplate().update(object);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public boolean saveOrUpdateObject(Object o) {

		try {
			this.getHibernateTemplate().saveOrUpdate(o);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public static List distinctList(List list) {

		List distinctList = new ArrayList();
		Set set = new HashSet(list);
		distinctList.addAll(set);
		return distinctList;

	}

	@Override
	public Integer getCount(final DetachedCriteria criteria) {

		Integer count = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Criteria execCriteria = criteria.getExecutableCriteria(session);
				CriteriaImpl criImpl = (CriteriaImpl) execCriteria;
				Projection projection = criImpl.getProjection();
				Object uniqueResult = execCriteria.setProjection(Projections.rowCount()).uniqueResult();// uniqueResult
				execCriteria.setProjection(projection);
				if (projection == null) {
					System.out.println("projection ==null");
					execCriteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
				}

				return (Integer) uniqueResult;
			}
		});

		return count;
	}

	@Override
	public <T> List<T> getList(DetachedCriteria criteria, Integer curPage, Integer perPageCount) {
		// TODO Auto-generated method stub

		return (List<T>) this.hibernateTemplate.findByCriteria(criteria, (curPage - 1) * perPageCount.intValue(),
				perPageCount);
	}

}
