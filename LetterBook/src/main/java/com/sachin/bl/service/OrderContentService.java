package com.sachin.bl.service;

import java.util.Map;

import com.sachin.bl.entities.OrderContentTable;
import com.sachin.bl.entities.Pagination;

public interface OrderContentService {

	public abstract Pagination<OrderContentTable> getListOrderContentPage(Map paramMap);

	public abstract OrderContentTable gainOrderContentByOcID(Integer paramInteger);

	public abstract boolean deleteOrderContentByOcID(Integer paramInteger);

	public abstract boolean saveOrderContent(OrderContentTable paramOrderContentTable);

	public abstract boolean updateOrderContent(OrderContentTable paramOrderContentTable);
}
