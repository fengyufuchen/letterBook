package com.sachin.bl.dao;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.OrderTable;

public interface OrderDao {
	public abstract Integer getListOrderCount(Map paramMap);

	public abstract List<OrderTable> getListOrderPage(Map paramMap);

	public abstract Integer getListOrderCountByBid(Map paramMap);

	public abstract List<OrderTable> getListOrderPageByBid(Map paramMap);

	public abstract Integer getListOrderCountByUid(Map paramMap);

	public abstract List<OrderTable> getListOrderPageByUid(Map paramMap);

	public abstract OrderTable gainOrderByOID(Integer paramInteger);

	public abstract Integer gainMaxOrderId();

	public abstract boolean deleteOrderByOID(Integer paramInteger);

	public abstract boolean saveOrder(OrderTable paramOrderTable);

	public abstract boolean updateOrder(OrderTable paramOrderTable);
}
