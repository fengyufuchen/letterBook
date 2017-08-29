package com.sachin.bl.dao;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.ShopCartContentTable;

public interface ShopCartContentDao {
	public abstract Integer getListShopcarContentCount(Map paramMap);

	public abstract List<ShopCartContentTable> getListShopcarContentPage(Map paramMap);

	public abstract boolean deleteShopcarContentBySccID(Integer paramInteger);

	public abstract boolean saveShopcarContent(ShopCartContentTable shopCartContentTable);

	public abstract boolean updateShopcarContent(ShopCartContentTable shopCartContentTable);

	public abstract ShopCartContentTable getShopcarContentBySccId(Integer paramInteger);

	public abstract ShopCartContentTable getShopcarContentByScId(Integer paramInteger);

	public abstract ShopCartContentTable getShopcarContentByScIdAndBoId(Integer paramInteger1, Integer paramInteger2);
}
