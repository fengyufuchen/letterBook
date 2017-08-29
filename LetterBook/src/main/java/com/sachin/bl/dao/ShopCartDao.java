package com.sachin.bl.dao;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.ShopCartTable;

public interface ShopCartDao {
	public abstract Integer getListShopcarCount(Map paramMap);

	public abstract List<ShopCartTable> getListShopcarPage(Map paramMap);

	public abstract boolean deleteShopcarByScID(Integer paramInteger);

	public abstract boolean saveShopcar(ShopCartTable shopCartTable);

	public abstract boolean updateShopcar(ShopCartTable shopCartTable);

	public abstract ShopCartTable getShopcarByScId(Integer paramInteger);

	public abstract ShopCartTable getShopcarByUid(Integer paramInteger);
}
