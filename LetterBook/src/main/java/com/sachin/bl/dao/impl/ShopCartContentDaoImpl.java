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

import com.sachin.bl.dao.ShopCartContentDao;
import com.sachin.bl.entities.ShopCartContentTable;

@Repository
public class ShopCartContentDaoImpl extends BaseDaoImpl implements ShopCartContentDao {

	public Integer getListShopcarContentCount(Map param) {
		Integer scid = Integer.valueOf(param.get("scid").toString());
		DetachedCriteria criteria = DetachedCriteria.forClass(ShopCartContentTable.class);
		criteria = criteria.createAlias("shopcar", "s");
		criteria.add(Restrictions.eq("s.scid", scid));

		criteria = criteria.setProjection(Projections.countDistinct("sccid"));
		Long count = (Long) this.hibernateTemplate.findByCriteria(criteria).get(0);
		return count.intValue();
	}

	public List<ShopCartContentTable> getListShopcarContentPage(Map param) {
		Integer pageNum = Integer.valueOf(param.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(param.get("pageSize").toString());
		Integer scid = Integer.valueOf(param.get("scid").toString());

		String orderField = (String) param.get("orderField");
		String orderDirection = (String) param.get("orderDirection");

		DetachedCriteria criteria=DetachedCriteria.forClass(ShopCartContentTable.class);
		criteria = criteria.createAlias("shopcar", "s");
		criteria.add(Restrictions.eq("s.scid", scid));
		if(StringUtils.isNotEmpty(orderField)&&StringUtils.isNotEmpty(orderDirection)&&StringUtils.isNoneEmpty(orderDirection)){
			
			if ("asc".equalsIgnoreCase(orderDirection)) {
				criteria.addOrder(Order.asc(orderField));
			} else {
				criteria.addOrder(Order.desc(orderField));
			}
			
		}
		List<ShopCartContentTable> shopcarContents = (List<ShopCartContentTable>) this.hibernateTemplate
				.findByCriteria(criteria, (pageNum.intValue() - 1) * pageSize.intValue(), pageSize.intValue());
		return shopcarContents;
	}

	public boolean deleteShopcarContentBySccID(Integer SccID) {
		String hql = "delete from ShopCartContentTable where SccID = ?";
		this.hibernateTemplate.bulkUpdate(hql, SccID);
		return true;
	}

	public boolean saveShopcarContent(ShopCartContentTable shopcarContent) {
		return saveObject(shopcarContent);
	}

	public boolean updateShopcarContent(ShopCartContentTable shopcarContent) {
		Session session = getSession();
		ShopCartContentTable shopcarCon = (ShopCartContentTable) session.get(ShopCartContentTable.class,
				shopcarContent.getSccid());
		shopcarCon.setNumber(shopcarContent.getNumber());
		session.update(shopcarCon);
		return true;
	}

	public ShopCartContentTable getShopcarContentBySccId(Integer sccid) {
		String hql = "from ShopCartContentTable where SccID=?";
		List<ShopCartContentTable> list = (List<ShopCartContentTable>) this.hibernateTemplate.find(hql, sccid);
		if (list.size() == 0) {
			return null;
		}

		return list.get(0);

	}

	public ShopCartContentTable getShopcarContentByScId(Integer scid) {
		String hql = "from ShopCartContentTable where ScID=?";
		List<ShopCartContentTable> list = (List<ShopCartContentTable>) this.hibernateTemplate.find(hql, scid);
		if (list.size() == 0) {
			return null;
		}
		ShopCartContentTable shopcarContent = (ShopCartContentTable) list.get(0);
		return shopcarContent;
	}

	public ShopCartContentTable getShopcarContentByScIdAndBoId(Integer scid, Integer boid) {
		String hql = "from ShopCartContentTable where ScID=? and BoID=?";
		List<ShopCartContentTable> list = (List<ShopCartContentTable>) this.hibernateTemplate.find(hql,
				new Object[] { scid, boid });
		if (list.size() == 0) {
			return null;
		}
		ShopCartContentTable shopcarContent = (ShopCartContentTable) list.get(0);
		return shopcarContent;
	}

}
