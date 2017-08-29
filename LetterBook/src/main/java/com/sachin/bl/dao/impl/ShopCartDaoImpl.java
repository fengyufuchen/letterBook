package com.sachin.bl.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.sachin.bl.dao.ShopCartDao;
import com.sachin.bl.entities.ShopCartTable;

@Repository
public class ShopCartDaoImpl extends BaseDaoImpl implements ShopCartDao {
	public Integer getListShopcarCount(Map param) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ShopCartTable.class);
		criteria = criteria.setProjection(Projections.countDistinct("scid"));
		Long count = (Long) this.hibernateTemplate.findByCriteria(criteria).get(0);
		return count.intValue();
	}

	public List<ShopCartTable> getListShopcarPage(Map param) {
		Integer pageNum = Integer.valueOf(param.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(param.get("pageSize").toString());

		String orderField = (String) param.get("orderField");
		String orderDirection = (String) param.get("orderDirection");

		DetachedCriteria criteria = DetachedCriteria.forClass(ShopCartTable.class);
		if ("asc".equalsIgnoreCase(orderDirection)) {
			criteria.addOrder(Order.asc(orderField));
		} else {
			criteria.addOrder(Order.desc(orderField));
		}
		List<ShopCartTable> shopcars = (List<ShopCartTable>) this.hibernateTemplate.findByCriteria(criteria,
				(pageNum.intValue() - 1) * pageSize.intValue(), pageSize.intValue());
		return shopcars;
	}

	public boolean deleteShopcarByScID(Integer ScID) {
		String hql = "delete from ShopCartTable where ScID = ?";
		this.hibernateTemplate.bulkUpdate(hql, ScID);
		return true;
	}

	public boolean saveShopcar(ShopCartTable shopcar) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		shopcar.setCreatetime(t);
		shopcar.setUpdatetime(t);
		return saveObject(shopcar);
	}

	public boolean updateShopcar(ShopCartTable shopcar) {
		Session session = getSession();
		ShopCartTable shop = (ShopCartTable) session.get(ShopCartTable.class, shopcar.getScid());
		shop.setEnabled(shopcar.getEnabled());
		Timestamp t = new Timestamp(System.currentTimeMillis());
		shop.setUpdatetime(t);
		session.update(shop);
		return true;
	}

	public ShopCartTable getShopcarByScId(Integer scid) {
		String hql = "from ShopCartTable where ScID=?";
		List<ShopCartTable> list = (List<ShopCartTable>) this.hibernateTemplate.find(hql, scid);
		if (list.size() == 0) {
			return null;
		}
		ShopCartTable shopcar = (ShopCartTable) list.get(0);
		return shopcar;
	}

	public ShopCartTable getShopcarByUid(Integer uid) {
		String hql = "from ShopCartTable where UID=?";
		List<ShopCartTable> list = (List<ShopCartTable>) this.hibernateTemplate.find(hql, uid);
		if (list.size() == 0) {
			return null;
		}
		ShopCartTable shopcar = (ShopCartTable) list.get(0);
		return shopcar;
	}
}
