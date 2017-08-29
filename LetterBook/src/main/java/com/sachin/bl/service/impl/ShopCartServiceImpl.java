package com.sachin.bl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.bl.dao.ShopCartDao;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.ShopCartTable;

@Service
public class ShopCartServiceImpl implements com.sachin.bl.service.ShopCartService {
	@Autowired
	private ShopCartDao shopcarDao;

	public Pagination<ShopCartTable> getListShopcarPage(Map param) {
		Pagination<ShopCartTable> page = new Pagination();
		List<ShopCartTable> shopcar = this.shopcarDao.getListShopcarPage(param);
		page.setContent(shopcar);
		page.setCurrentPage((Integer) param.get("pageNum"));
		page.setNumPerPage((Integer) param.get("pageSize"));
		page.setTotalCount(this.shopcarDao.getListShopcarCount(param));
		page.calculatePage();
		return page;
	}

	public boolean deleteShopcarByScID(Integer ScID) {
		return this.shopcarDao.deleteShopcarByScID(ScID);
	}

	public boolean saveShopcar(ShopCartTable shopcar) {

		this.shopcarDao.saveShopcar(shopcar);

		return true;
	}

	public boolean updateShopcar(ShopCartTable shopcar) {
		return this.shopcarDao.updateShopcar(shopcar);
	}

	public ShopCartTable getShopcarByScId(Integer scid) {
		return this.shopcarDao.getShopcarByScId(scid);
	}

	public ShopCartTable getShopcarByUid(Integer uid) {
		return this.shopcarDao.getShopcarByUid(uid);
	}
}
