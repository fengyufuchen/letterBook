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

import com.sachin.bl.dao.BusinessDao;
import com.sachin.bl.entities.BusinessTable;

@Repository
public class BusinessDaoImpl extends BaseDaoImpl implements BusinessDao {

	@Override
	public List<BusinessTable> getListBusinessPage(Map paramMap) {
		// TODO Auto-generated method stub

		BusinessTable businessTable = (BusinessTable) paramMap.get("condition");

		Integer curPageNum = Integer.valueOf(paramMap.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(paramMap.get("pageSize").toString());

		String orderField = (String) paramMap.get("orderField");
		String orderDirection = (String) paramMap.get("orderDirection");

		DetachedCriteria criteria = DetachedCriteria.forClass(BusinessTable.class);
		if (StringUtils.isNotEmpty(businessTable.getBaccount())) {
			criteria = criteria.add(Restrictions.like("baccount", "%" + businessTable.getBaccount() + "%"));
		}
		if (businessTable.getBname() != null) {
			criteria = criteria.add(Restrictions.like("bname", "%" + businessTable.getBname() + "%"));
		}
		if (StringUtils.isNoneEmpty(orderDirection) && StringUtils.isNotEmpty(orderField)) {
			if ("asc".equalsIgnoreCase(orderDirection)) {
				criteria.addOrder(Order.asc(orderField));
			} else {
				criteria.addOrder(Order.desc(orderField));
			}
		}

		// @formatter:on

		List<BusinessTable> btList = (List<BusinessTable>) this.hibernateTemplate.findByCriteria(criteria,
				(curPageNum - 1) * pageSize, pageSize);

		return btList;
	}

	@Override
	public BusinessTable getBusinessByAccount(String paramString) {
		// TODO Auto-generated method stub

		String hql = "from BusinessTable where  baccount=?";
		List<BusinessTable> btList = (List<com.sachin.bl.entities.BusinessTable>) this.hibernateTemplate.find(hql,
				paramString);
		try {
			return btList.get(0);

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}

	}

	@Override
	public void modifyPassword(BusinessTable paramBusinessTable, String npwd) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from BusinessTable set bpasw =? where  bid=?";
		this.hibernateTemplate.bulkUpdate(hql, new Object[] { npwd, paramBusinessTable.getBid() });

	}

	@Override
	public Integer getListBusinessCount(Map paramMap) {
		// TODO Auto-generated method stub
		BusinessTable businessTable = (BusinessTable) paramMap.get("condition");

		Integer curPageNum = Integer.valueOf(paramMap.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(paramMap.get("pageSize").toString());

		String orderField = (String) paramMap.get("orderField");
		String orderDirection = (String) paramMap.get("orderDirection");

		DetachedCriteria criteria = DetachedCriteria.forClass(BusinessTable.class);
		if (StringUtils.isNotEmpty(businessTable.getBaccount())) {
			criteria = criteria.add(Restrictions.like("baccount", "%" + businessTable.getBaccount() + "%"));
		}
		if (businessTable.getBname() != null) {
			criteria = criteria.add(Restrictions.like("bname", "%" + businessTable.getBname() + "%"));
		}
		if (StringUtils.isNoneEmpty(orderDirection) && StringUtils.isNotEmpty(orderField)) {
			if ("asc".equalsIgnoreCase(orderDirection)) {
				criteria.addOrder(Order.asc(orderField));
			} else {
				criteria.addOrder(Order.desc(orderField));
			}
		}

		// @formatter:on

		criteria.setProjection(Projections.countDistinct("bid"));
		Integer count = ((Long) this.hibernateTemplate.findByCriteria(criteria).get(0)).intValue();

		return count;

	}

	@Override
	public boolean deleteBusinessByBid(Integer paramInteger) {
		// TODO Auto-generated method stub
		String hql = "delete from BusinessTable where bid=?";
		this.hibernateTemplate.bulkUpdate(hql, paramInteger);

		return true;
	}

	@Override
	public boolean saveBusiness(BusinessTable paramBusinessTable) {
		// TODO Auto-generated method stub
		Timestamp t = new Timestamp(System.currentTimeMillis());
		paramBusinessTable.setCreatetime(t);
		paramBusinessTable.setUpdatetime(t);
		return saveObject(paramBusinessTable);
	}

	@Override
	public boolean updateBusiness(BusinessTable business) {
		// TODO Auto-generated method stub

		Session session = getSession();
		BusinessTable busines = (BusinessTable) session.get(BusinessTable.class, business.getBid());
		busines.setBname(business.getBname());
		busines.setBsex(business.getBsex());
		busines.setBphone(business.getBphone());
		busines.setBemail(business.getBemail());
		busines.setBadr(business.getBadr());
		busines.setBidcard(business.getBidcard());
		busines.setBpsw(business.getBpsw());
		busines.setEnabled(business.getEnabled());
		Timestamp t = new Timestamp(System.currentTimeMillis());
		busines.setUpdatetime(t);
		session.update(busines);
		return true;

	}

	@Override
	public BusinessTable getBusinessByBid(Integer bid) {
		// TODO Auto-generated method stub
		Session session = getSession();
		return (BusinessTable) session.get(BusinessTable.class, bid);
	}

	@Override
	public List<BusinessTable> getAllBusiness() {
		// TODO Auto-generated
		String hql = "from BusinessTable";
		List<BusinessTable> Business = (List<BusinessTable>) this.hibernateTemplate.find(hql);
		return Business;
	}

}
