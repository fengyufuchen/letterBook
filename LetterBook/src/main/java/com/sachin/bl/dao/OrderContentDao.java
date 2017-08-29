package com.sachin.bl.dao;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.OrderContentTable;

public interface OrderContentDao {
	 public abstract Integer getListOrderContentCount(Map paramMap);
	  
	  public abstract List<OrderContentTable> getListOrderContentPage(Map paramMap);
	  
	  public abstract OrderContentTable gainOrderContentByOcID(Integer paramInteger);
	  
	  public abstract boolean deleteOrderContentByOcID(Integer paramInteger);
	  
	  public abstract boolean saveOrderContent(OrderContentTable paramOrderContentTable);
	  
	  public abstract boolean updateOrderContent(OrderContentTable paramOrderContentTable);
}
