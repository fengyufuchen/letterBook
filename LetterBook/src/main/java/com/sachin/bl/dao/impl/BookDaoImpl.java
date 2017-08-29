package com.sachin.bl.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.sachin.bl.dao.BookDao;
import com.sachin.bl.entities.AdminTable;
import com.sachin.bl.entities.BookTable;

@Repository
public class BookDaoImpl extends BaseDaoImpl implements BookDao {

	@Override
	public List<BookTable> getListBookPage(Map paraMap) {
		// TODO Auto-generated method stub

		Integer curPageNum = Integer.valueOf(paraMap.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(paraMap.get("pageSize").toString());
		String orderField = (String) paraMap.get("orderField");
		String orderDirection = (String) paraMap.get("orderDirection");

		BookTable condition = (BookTable) paraMap.get("condition");
		// 创建离线查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BookTable.class);

		if (!StringUtils.isEmpty(condition.getBoname())) {
			detachedCriteria.add(Restrictions.like("boname", "%" + condition.getBoname() + "%"));
		}
		if (!StringUtils.isEmpty(condition.getBoauthor())) {
			detachedCriteria.add(Restrictions.like("boauthor", "%" + condition.getBoauthor() + "%"));

		}
		if (orderDirection != null && orderField != null) {
			if ("asc".equalsIgnoreCase(orderDirection)) {
				detachedCriteria.addOrder(Order.asc(orderField));
			} else {
				detachedCriteria.addOrder(Order.desc(orderField));
			}
		}

		// 直接使用hibernate提供的分页查询api
		List<BookTable> bkList = (List<BookTable>) this.hibernateTemplate.findByCriteria(detachedCriteria,
				(curPageNum - 1) * pageSize, pageSize);
		return bkList;
	}

	@Override
	public Integer getListBookCountByBID(Map paraMap) {
		// TODO Auto-generated method stub

		Criteria createCriteria = this.getSession().createCriteria(AdminTable.class);

		BookTable condition = (BookTable) paraMap.get("condition");

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BookTable.class);// 在线criteria都是通过session.
																						// createQuery
																						// 或者createCriteria创建
		if (condition.getBoname() != null) {
			detachedCriteria.add(Restrictions.like("boname", "%" + condition.getBoname() + "%"));
		}
		if (condition.getBoauthor() != null) {

			detachedCriteria.add(Restrictions.like("bauthor", "%" + condition.getBoauthor() + "%"));
		}
		// 设置一个投影查询字段，Projections.max("price")
		detachedCriteria.setProjection(Projections.countDistinct("boid"));
		List<?> reList =  this.hibernateTemplate.findByCriteria(detachedCriteria);

		return ((Long) reList.get(0)).intValue();
	}

	@Override
	public boolean deleteBookByBoID(Integer id) {
		// TODO Auto-generated method stub

		String hql = " delete from BookTable where boid=:id";
		Query query = this.getSession().createQuery(hql);
		query.setInteger("id", id);
		query.executeUpdate();
		// this.hibernateTemplate.bulkUpdate(queryString, values),可以实现删除和更新

		return true;
	}

	@Override
	public Integer getListBookCount(Map paramMap) {
		// TODO Auto-generated method stub

		BookTable condition = (BookTable) paramMap.get("condition");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BookTable.class);

		if (!StringUtils.isEmpty(condition.getBoname())) {

			detachedCriteria.add(Restrictions.like("boname", "%" + condition.getBoname() + "%"));

		}
		if (!StringUtils.isEmpty(condition.getBoauthor())) {
			detachedCriteria.add(Restrictions.like("boauthor", "%" + condition.getBoauthor() + "%"));
		}

		detachedCriteria.setProjection(Projections.countDistinct("boid"));

		List<?> bkList =  this.hibernateTemplate.findByCriteria(detachedCriteria);
		return ((Long) bkList.get(0)).intValue();
	}

	@Override
	public List<BookTable> getListBookPageByBID(Map paraMap) {
		// TODO Auto-generated method stub

		Integer curPageNum = Integer.valueOf(paraMap.get("curPageNum").toString());
		Integer pageSize = Integer.valueOf(paraMap.get("pageSize").toString());
		Integer bid = Integer.valueOf(paraMap.get("bid").toString());

		String orderField = paraMap.get("orderField").toString();
		String orderDirection = (String) paraMap.get("orderDirection");

		BookTable bookTable = (BookTable) paraMap.get("condition");

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BookTable.class);
		detachedCriteria.add(Restrictions.eq("business.bid", bid));
		if (!StringUtils.isEmpty(bookTable.getBoname())) {

			detachedCriteria.add(Restrictions.like("boname", "%" + bookTable.getBoname() + "%"));
		}
		if (!StringUtils.isEmpty(bookTable.getBoauthor())) {
			detachedCriteria.add(Restrictions.like("boauthor", "%" + bookTable.getBoauthor() + "%"));
		}
		if (orderDirection != null && orderField != null) {
			if ("asc".equalsIgnoreCase(orderDirection)) {
				detachedCriteria.addOrder(Order.asc(orderField));
			} else {
				detachedCriteria.addOrder(Order.desc(orderField));
			}
		}

		List<BookTable> bkList = (List<BookTable>) this.hibernateTemplate.findByCriteria(detachedCriteria,
				(curPageNum - 1) * pageSize.intValue(), pageSize);

		return bkList;
	}

	@Override
	public BookTable gainBookByBoName(String name) {
		// TODO Auto-generated method stub

		String hql = "from BookTable where boname=?";
		List<BookTable> bkList = (List<BookTable>) this.hibernateTemplate.find(hql, name);
		if (bkList.size() == 0) {
			return null;
		}
		BookTable book = bkList.get(0);
		return book;

	}

	@Override
	public BookTable getBookByBoID(Integer boid) {
		// TODO Auto-generated method stub
		String hql = "from BookTable where boid=?";
		List<BookTable> bkList = (List<BookTable>) this.hibernateTemplate.find(hql, boid);

		if (bkList.size() == 0) {
			return null;
		}
		return bkList.get(0);
	}

	@Override
	public boolean saveBook(BookTable booktable) {
		// TODO Auto-generated method stub
		java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());
		booktable.setCreatetime(time);
		booktable.setUpdatetime(time);

		return saveObject(booktable);
	}

	@Override
	public boolean updateBook(BookTable book) {

		Session session = getSession();
		BookTable bok = (BookTable) session.get(BookTable.class, book.getBoid());

		bok.setBoname(book.getBoname());
		bok.setBoauthor(book.getBoauthor());
		bok.setBopress(book.getBopress());
		bok.setBoprice(book.getBoprice());
		bok.setBotime(book.getBotime());
		bok.setBosummary(book.getBosummary());
		bok.setBonumber(book.getBonumber());
		bok.setBoamount(book.getBoamount());
		bok.setEnabled(book.getEnabled());

		Timestamp t = new Timestamp(System.currentTimeMillis());
		bok.setUpdatetime(t);
		session.update(bok);
		return true;
	}

	@Override
	public List<BookTable> getAllBook() {
		// TODO Auto-generated method stub

		String hql = "from BookTable";
		List<BookTable> btList = (List<BookTable>) this.getHibernateTemplate().find(hql);
		return btList;
	}

}
