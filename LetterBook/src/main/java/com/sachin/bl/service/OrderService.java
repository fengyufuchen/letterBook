package com.sachin.bl.service;

import java.util.Map;

import com.sachin.bl.entities.OrderTable;
import com.sachin.bl.entities.Pagination;

public interface OrderService {

	public abstract Pagination<OrderTable> getListOrderPage(Map paramMap);

	public abstract Pagination<OrderTable> getListOrderPageByBid(Map paramMap);

	public abstract Pagination<OrderTable> getListOrderPageByUid(Map paramMap);

	public abstract OrderTable gainOrderByOID(Integer paramInteger);

	public abstract Integer gainMaxOrderId();

	public abstract boolean deleteOrderByOID(Integer paramInteger);

	public abstract boolean saveOrder(OrderTable paramOrderTable);

	public abstract boolean updateOrder(OrderTable paramOrderTable);
}
