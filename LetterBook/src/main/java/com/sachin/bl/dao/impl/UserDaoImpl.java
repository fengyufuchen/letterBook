package com.sachin.bl.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.CountProjection;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sachin.bl.dao.UserDao;
import com.sachin.bl.entities.AdminTable;
import com.sachin.bl.entities.UserTable;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public List<UserTable> getListUserPage(Map paramMap) {
		// TODO Auto-generated method stub
		Integer curPageNum = Integer.valueOf(paramMap.get("curPageNum").toString());
		Integer pageSize = Integer.valueOf(paramMap.get("pageSize").toString());

		String orderField = (String) paramMap.get("orderField");
		String orderDirection = (String) paramMap.get("orderDirection");

		UserTable condition = (UserTable) paramMap.get("condition");

		DetachedCriteria criteria = DetachedCriteria.forClass(UserTable.class);
		if (condition.getUaccount() != null) {
			criteria = criteria.add(Restrictions.like("uaccount", "%" + condition.getUaccount() + "%"));
		}
		if (condition.getUname() != null) {
			criteria = criteria.add(Restrictions.like("uname", "%" + condition.getUname() + "%"));
		}
		if (orderDirection != null && orderField != null) {
			if ("asc".equalsIgnoreCase(orderDirection)) {
				criteria.addOrder(Order.asc(orderField));
			} else {
				criteria.addOrder(Order.desc(orderField));
			}
		}
		List<UserTable> users = (List<UserTable>) hibernateTemplate.findByCriteria(criteria,
				(curPageNum.intValue() - 1) * pageSize.intValue(), pageSize.intValue());
		return users;

	}

	@Override
	public UserTable gainUserByAccount(String name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String hql = " from UserTable where uname=?";

		List<UserTable> adList = (List<UserTable>) this.hibernateTemplate.find(hql, name);
		if (adList.size() == 0)
			return null;

		return (UserTable) getSession().load(UserTable.class, adList.get(0).getUid());
	}

	@Override
	public void modifyPassword(UserTable paramUserTable, String pas) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from UserTable  set upsw=?";
		this.hibernateTemplate.find(hql, pas);

	}

	@Override
	public Integer getListUserCount(Map paramMap) {
		// TODO Auto-generated method stub

		UserTable userTable = (UserTable) paramMap.get("condition");

		DetachedCriteria detachedCritera = DetachedCriteria.forClass(UserTable.class);
		if (StringUtils.isNotEmpty(userTable.getUaccount())) {

			detachedCritera.add(Restrictions.like("uaccount", "%" + userTable.getUaccount() + "%"));

		}
		if (StringUtils.isNoneEmpty(userTable.getUname())) {
			detachedCritera.add(Restrictions.like("uname", "%" + userTable.getUname() + "%"));
		}
		CountProjection countDistinct = Projections.countDistinct("uid");
		detachedCritera.setProjection(countDistinct);
		List<Long> count = (List<Long>) this.hibernateTemplate.findByCriteria(detachedCritera);

		try {
			return count.get(0).intValue();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public boolean deleteUserByUid(Integer uid) {
		// TODO Auto-generated method stub
		String hql = "delete from UserTable where uid =?";

		this.hibernateTemplate.bulkUpdate(hql, uid);
		return true;

	}

	@Override
	public boolean saveUser(UserTable user) {
		// TODO Auto-generated method stub
		Timestamp t = new Timestamp(System.currentTimeMillis());
		user.setCreatetime(t);
		user.setUpdatetime(t);
		return saveObject(user);

	}

	@Override
	public boolean updateUser(UserTable paramUserTable) {
		// TODO Auto-generated method stub
		Session session = getSession();
		UserTable user = (UserTable) session.load(UserTable.class, paramUserTable.getUid());
		user.setUname(paramUserTable.getUname());

		user.setUname(user.getUname());
		user.setUphone(user.getUphone());
		user.setUemail(user.getUemail());
		user.setUadr(user.getUadr());
		Timestamp t = new Timestamp(System.currentTimeMillis());
		user.setUpdatetime(t);
		session.update(user);

		return false;
	}

	@Override
	public UserTable getUserByUid(Integer paramInteger) {
		// TODO Auto-generated method stub
		Session session = getSession();
		UserTable user = (UserTable) session.load(UserTable.class, paramInteger);

		return user;
	}

	@Override
	public List<UserTable> getAllUser() {
		// TODO Auto-generated method stub
		String hql = "from UserTable";
		List<UserTable> user = (List<UserTable>) getHibernateTemplate().find(hql);
		return user;
	}

}
