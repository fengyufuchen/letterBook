package com.sachin.bl.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sachin.bl.dao.OrderContentDao;
import com.sachin.bl.entities.OrderContentTable;

@Repository
public class OrderContentDaoImpl extends BaseDaoImpl implements OrderContentDao {

	@Override
	public Integer getListOrderContentCount(Map paramMap) {
		// TODO Auto-generated method stub

		Integer oid = Integer.valueOf(paramMap.get("oid").toString());

		DetachedCriteria detachedCritera = DetachedCriteria.forClass(OrderContentTable.class);

		detachedCritera.createAlias("orderTable", "o");
		detachedCritera.add(Restrictions.eq("o.oid", oid));
		detachedCritera.setProjection(Projections.countDistinct("ocid"));

		Long count = (Long) this.hibernateTemplate.findByCriteria(detachedCritera).get(0);

		return count.intValue();
	}

	@Override
	public List<OrderContentTable> getListOrderContentPage(Map paramMap) {

		Integer pageNum = Integer.valueOf(paramMap.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(paramMap.get("pageSize").toString());

		Integer oid = Integer.valueOf(paramMap.get("oid").toString());

		String orderField = (String) paramMap.get("orderField");
		String orderDirection = (String) paramMap.get("orderDirection");

		DetachedCriteria detachedCritera = DetachedCriteria.forClass(OrderContentTable.class);

		detachedCritera.createCriteria("orderTable", "o");
		detachedCritera.add(Restrictions.eq("o.oid", oid));

		if (StringUtils.isNotEmpty(orderDirection) && StringUtils.isNotEmpty(orderField)) {

			detachedCritera.add(Restrictions.eq("o.oid", oid));
			if ("asc".equalsIgnoreCase(orderDirection)) {
				detachedCritera.addOrder(Order.asc(orderField));
			} else {
				detachedCritera.addOrder(Order.desc(orderField));
			}

		}
		List<OrderContentTable> octList = (List<OrderContentTable>) this.hibernateTemplate
				.findByCriteria(detachedCritera, (pageNum - 1) * pageSize, pageSize);

		return octList;

	}

	@Override
	public OrderContentTable gainOrderContentByOcID(Integer paramInteger) {
		// TODO Auto-generated method stub
		String sql = "from OrderContentTable where ocid=?";

		List<OrderContentTable> octList = (List<OrderContentTable>) this.hibernateTemplate.find(sql, paramInteger);

		try {
			return octList.get(0);

		} catch (Exception e) {

			// TODO: handle exception

			return null;
		}

	}

	@Override
	public boolean deleteOrderContentByOcID(Integer paramInteger) {
		// TODO Auto-generated method stub
		String hql = "delete form OrderContentTable where ocid=?";
		int bulkUpdate = this.hibernateTemplate.bulkUpdate(hql, paramInteger);

		return true;
	}

	@Override
	public boolean saveOrderContent(OrderContentTable paramOrderContentTable) {
		// TODO Auto-generated method stub

		this.hibernateTemplate.save(paramOrderContentTable);
		return true;
	}

	@Override
	public boolean updateOrderContent(OrderContentTable paramOrderContentTable) {

		// TODO Auto-generated method stub
		Session session = this.getSession();
		OrderContentTable octBean = (OrderContentTable) session.load(OrderContentTable.class,
				paramOrderContentTable.getOcid());

		octBean.setNumber(paramOrderContentTable.getNumber());
		session.update(octBean);

		return true;

	}

}
