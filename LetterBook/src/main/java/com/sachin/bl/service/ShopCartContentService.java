package com.sachin.bl.service;

import java.util.Map;

import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.ShopCartContentTable;

public interface ShopCartContentService {

	public abstract Pagination<ShopCartContentTable> getListShopcarContentPage(Map paramMap);

	public abstract boolean deleteShopcarContentBySccID(Integer paramInteger);

	public abstract boolean saveShopcarContent(ShopCartContentTable shopCartContentTable);

	public abstract boolean updateShopcarContent(ShopCartContentTable shopCartContentTable);

	public abstract ShopCartContentTable getShopcarContentBySccId(Integer paramInteger);

	public abstract ShopCartContentTable getShopcarContentByScId(Integer paramInteger);

	public abstract ShopCartContentTable getShopcarContentByScIdAndBoId(Integer paramInteger1, Integer paramInteger2);
}
