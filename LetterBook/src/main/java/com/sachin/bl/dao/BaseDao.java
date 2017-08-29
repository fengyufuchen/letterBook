package com.sachin.bl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao {

	SessionFactory getSessionFactory();

	Integer getCount(DetachedCriteria criteria);

	<T> List<T>getList(DetachedCriteria criteria, Integer 	curPage, Integer perPageCount);
}
