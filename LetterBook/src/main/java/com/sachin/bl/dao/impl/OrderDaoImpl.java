package com.sachin.bl.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sachin.bl.dao.OrderDao;
import com.sachin.bl.entities.OrderTable;

@Repository

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

	@Override
	public Integer getListOrderCount(Map paramMap) {
		// TODO Auto-generated method stub

		/* Integer oid = Integer.valueOf(paramMap.get("oid").toString()); */

		DetachedCriteria criteria = DetachedCriteria.forClass(OrderTable.class);

		criteria.setProjection(Projections.count("oid"));
		/*
		 * criteria.add(Restrictions.eq("oid", oid));
		 */

		Integer count = ((Long) this.hibernateTemplate.findByCriteria(criteria).get(0)).intValue();

		return count;
	}

	@Override
	public List<OrderTable> getListOrderPage(Map paramMap) {
		// TODO Auto-generated method stub

		Integer oid = Integer.valueOf(paramMap.get("oid").toString());

		Integer pageNum = Integer.valueOf(paramMap.get("pageNum").toString());
		Integer pageSie = Integer.valueOf(paramMap.get("pageSize").toString());

		String orderField = (String) paramMap.get("orderField");
		String orderDirection = (String) paramMap.get("orderDirection");

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OrderTable.class);

		if (StringUtils.isNoneEmpty(orderDirection) && StringUtils.isNotEmpty(orderField)) {
			if ("asc".equals(orderDirection)) {

				detachedCriteria.addOrder(Order.asc(orderDirection));
			} else {

				detachedCriteria.addOrder(Order.desc(orderDirection));

			}

		}

		List<OrderTable> orderTable = (List<OrderTable>) this.hibernateTemplate.findByCriteria(detachedCriteria,
				(pageNum - 1) * pageSie, pageSie);

		return orderTable;
	}

	@Override
	public Integer getListOrderCountByBid(Map paramMap) {
		// TODO Auto-generated method stub\

		Integer bid = Integer.valueOf(paramMap.get("bid").toString());
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OrderTable.class);

		detachedCriteria.createAlias("businessTable", "bs");
		detachedCriteria.add(Restrictions.eq("bs.bid", bid));
		detachedCriteria.setProjection(Projections.countDistinct("oid"));

		Long count = (Long) hibernateTemplate.findByCriteria(detachedCriteria).get(0);

		return count.intValue();
	}

	@Override
	public List<OrderTable> getListOrderPageByBid(Map paramMap) {
		// TODO Auto-generated method stub

		Integer bid = Integer.valueOf(paramMap.get("bid").toString());

		Integer pageNum = Integer.valueOf(paramMap.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(paramMap.get("pageSize").toString());

		String orderField = (String) paramMap.get("orderField");
		String orderDirection = (String) paramMap.get("orderDirection");

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OrderTable.class);

		detachedCriteria.createAlias("businessTable", "bs");
		detachedCriteria.add(Restrictions.eq("bs.bid", bid));
		detachedCriteria.setProjection(Projections.countDistinct("oid"));

		if (StringUtils.isNotEmpty(orderDirection) && StringUtils.isNotEmpty(orderField)) {

			if ("asc".equals(orderDirection)) {
				detachedCriteria.addOrder(Order.asc(orderField));
			} else {
				detachedCriteria.addOrder(Order.desc(orderField));
			}

		}

		Integer count = (Integer) hibernateTemplate.findByCriteria(detachedCriteria).get(0);

		return null;
	}

	@Override
	public Integer getListOrderCountByUid(Map paramMap) {
		// TODO Auto-generated method stub
		Integer uid = Integer.valueOf(paramMap.get("uid").toString());

		DetachedCriteria criteria = DetachedCriteria.forClass(OrderTable.class);
		criteria.createAlias("userTable", "u");
		criteria.add(Restrictions.eq("user.uid", uid));

		criteria.setProjection(Projections.countDistinct("oid"));
		Long count = (Long) this.hibernateTemplate.findByCriteria(criteria).get(0);

		return count.intValue();
	}

	@Override
	public List<OrderTable> getListOrderPageByUid(Map param) {
		// TODO Auto-generated method stub

		Integer pageNum = Integer.valueOf(param.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(param.get("pageSize").toString());
		Integer uid = Integer.valueOf(param.get("uid").toString());

		DetachedCriteria criteria = DetachedCriteria.forClass(OrderTable.class);
		criteria.add(Restrictions.eq("userTable.uid", uid));

		List<OrderTable> orders = (List<OrderTable>) this.hibernateTemplate.findByCriteria(criteria,
				(pageNum.intValue() - 1) * pageSize.intValue(), pageSize.intValue());
		return orders;
	}

	@Override
	public OrderTable gainOrderByOID(Integer OID) {
		// TODO Auto-generated method stub
		String hql = "from OrderTable where OID = ?";
		List<OrderTable> list = (List<OrderTable>) this.hibernateTemplate.find(hql, OID);
		if (list.size() == 0) {
			return null;
		}
		OrderTable order = (OrderTable) list.get(0);
		return order;
	}

	@Override
	public Integer gainMaxOrderId() {
		// TODO Auto-generated method stub
		String hql = "select max(oid) from OrderTable";
		List<Integer> list = (List<Integer>) this.hibernateTemplate.find(hql);
		if (list.size() == 0) {
			return null;
		}
		int a = ((Integer) list.get(0)).intValue();
		return Integer.valueOf(a);
	}

	@Override
	public boolean deleteOrderByOID(Integer Oid) {
		// TODO Auto-generated method stub
		String hql = "delete from OrderTable where OID = ?";
		this.hibernateTemplate.bulkUpdate(hql, Oid);
		return true;
	}

	@Override
	public boolean saveOrder(OrderTable order) {
		// TODO Auto-generated method stub

		Timestamp t = new Timestamp(System.currentTimeMillis());
		order.setCreatetime(t);
		order.setUpdatetime(t);
		order.setOtime(t);
		return saveObject(order);
	}

	@Override
	public boolean updateOrder(OrderTable order) {
		Session session = getSession();
		OrderTable ord = (OrderTable) session.get(OrderTable.class, order.getOid());
		ord.setOname(order.getOname());
		ord.setOadr(order.getOadr());
		ord.setOphone(order.getOphone());
		ord.setOtime(order.getOtime());
		ord.setOprice(order.getOprice());
		ord.setOstate(order.getOstate());
		ord.setEnabled(order.getEnabled());
		Timestamp t = new Timestamp(System.currentTimeMillis());
		ord.setUpdatetime(t);
		session.update(ord);
		return true;
	}

}
