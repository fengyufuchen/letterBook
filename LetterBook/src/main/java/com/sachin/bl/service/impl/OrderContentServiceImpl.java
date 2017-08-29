package com.sachin.bl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.bl.dao.OrderContentDao;
import com.sachin.bl.entities.OrderContentTable;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.service.OrderContentService;

@Service
public class OrderContentServiceImpl implements OrderContentService {

	@Autowired
	private OrderContentDao orderContentDao;

	@Override
	public Pagination<OrderContentTable> getListOrderContentPage(Map paramMap) {
		// TODO Auto-generated method stub
		List<OrderContentTable> listOrderContentPage = orderContentDao.getListOrderContentPage(paramMap);

		Pagination<OrderContentTable> pagination = new Pagination<>();
		pagination.setContent(listOrderContentPage);
		pagination.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));

		pagination.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));
		pagination.setTotalCount(orderContentDao.getListOrderContentCount(paramMap));
		pagination.calculatePage();

		return pagination;

	}

	@Override
	public OrderContentTable gainOrderContentByOcID(Integer paramInteger) {
		// TODO Auto-generated method stub

		OrderContentTable gainOrderContentByOcID = orderContentDao.gainOrderContentByOcID(paramInteger);

		return gainOrderContentByOcID;
	}

	@Override
	public boolean deleteOrderContentByOcID(Integer paramInteger) {
		// TODO Auto-generated method stub
		return orderContentDao.deleteOrderContentByOcID(paramInteger);
	}

	@Override
	public boolean saveOrderContent(OrderContentTable paramOrderContentTable) {
		// TODO Auto-generated method stub
		return orderContentDao.saveOrderContent(paramOrderContentTable);
	}

	@Override
	public boolean updateOrderContent(OrderContentTable paramOrderContentTable) {
		// TODO Auto-generated method stub
		return orderContentDao.updateOrderContent(paramOrderContentTable);
	}

}
