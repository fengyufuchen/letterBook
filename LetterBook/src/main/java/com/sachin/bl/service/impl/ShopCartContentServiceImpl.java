package com.sachin.bl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.bl.dao.ShopCartContentDao;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.ShopCartContentTable;
import com.sachin.bl.service.ShopCartContentService;

@Service
public class ShopCartContentServiceImpl implements ShopCartContentService {

	@Autowired
	private ShopCartContentDao shopCartContentDao;

	@Override
	public Pagination<ShopCartContentTable> getListShopcarContentPage(Map paramMap) {
		// TODO Auto-generated method stub
		List<ShopCartContentTable> listShopcarContentPage = shopCartContentDao.getListShopcarContentPage(paramMap);

		Pagination<ShopCartContentTable> paginationi = new Pagination<>();

		paginationi.setContent(listShopcarContentPage);
		paginationi.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		paginationi.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));
		paginationi.setTotalCount(shopCartContentDao.getListShopcarContentCount(paramMap));
		paginationi.calculatePage();

		return paginationi;
	}

	@Override
	public boolean deleteShopcarContentBySccID(Integer paramInteger) {
		// TODO Auto-generated method stub

		shopCartContentDao.deleteShopcarContentBySccID(paramInteger);

		return true;
	}

	@Override
	public boolean saveShopcarContent(ShopCartContentTable shopCartContentTable) {
		// TODO Auto-generated method stub
		return shopCartContentDao.saveShopcarContent(shopCartContentTable);
	}

	@Override
	public boolean updateShopcarContent(ShopCartContentTable shopCartContentTable) {
		// TODO Auto-generated method stub
		return shopCartContentDao.updateShopcarContent(shopCartContentTable);
	}

	@Override
	public ShopCartContentTable getShopcarContentBySccId(Integer sccid) {
		// TODO Auto-generated method stub
		return shopCartContentDao.getShopcarContentBySccId(sccid);
	}

	@Override
	public ShopCartContentTable getShopcarContentByScId(Integer scid) {
		// TODO Auto-generated method stub
		return shopCartContentDao.getShopcarContentByScId(scid);
	}

	@Override
	public ShopCartContentTable getShopcarContentByScIdAndBoId(Integer paramInteger1, Integer paramInteger2) {
		// TODO Auto-generated method stub
		return shopCartContentDao.getShopcarContentByScIdAndBoId(paramInteger1, paramInteger2);
	}

}
