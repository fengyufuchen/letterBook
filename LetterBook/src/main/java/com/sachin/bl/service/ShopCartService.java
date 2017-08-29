package com.sachin.bl.service;

import java.util.Map;

import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.ShopCartTable;

public interface ShopCartService {
	public abstract Pagination<ShopCartTable> getListShopcarPage(Map paramMap);
	  
	  public abstract boolean deleteShopcarByScID(Integer paramInteger);
	  
	  public abstract boolean saveShopcar(ShopCartTable shopCartTable);
	  
	  public abstract boolean updateShopcar(ShopCartTable shopCartTable);
	  
	  public abstract ShopCartTable getShopcarByScId(Integer paramInteger);
	  
	  public abstract ShopCartTable getShopcarByUid(Integer paramInteger);
}
