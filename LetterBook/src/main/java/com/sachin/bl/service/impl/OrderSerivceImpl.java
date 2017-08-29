package com.sachin.bl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.bl.dao.OrderDao;
import com.sachin.bl.entities.OrderTable;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.service.OrderService;

@Service
public class OrderSerivceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public Pagination<OrderTable> getListOrderPage(Map paramMap) {
		// TODO Auto-generated method stub

		List<OrderTable> listOrderPage = orderDao.getListOrderPage(paramMap);

		Pagination<OrderTable> pagination = new Pagination<>();

		pagination.setContent(listOrderPage);
		pagination.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		pagination.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));
		pagination.calculatePage();
		return pagination;
	}

	@Override
	public Pagination<OrderTable> getListOrderPageByBid(Map paramMap) {
		// TODO Auto-generated method stub

		List<OrderTable> listOrderPageByBid = orderDao.getListOrderPageByBid(paramMap);
		Pagination<OrderTable> pagination = new Pagination<>();

		pagination.setContent(listOrderPageByBid);
		pagination.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		pagination.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));
		pagination.calculatePage();
		return pagination;
	}

	@Override
	public Pagination<OrderTable> getListOrderPageByUid(Map paramMap) {

		// TODO Auto-generated method stub
		List<OrderTable> listOrderPageByUid = orderDao.getListOrderPageByUid(paramMap);

		Pagination<OrderTable> pagination = new Pagination<>();

		pagination.setContent(listOrderPageByUid);
		pagination.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		pagination.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));
		pagination.setTotalCount(listOrderPageByUid.size());
		pagination.calculatePage();
		System.out.println(pagination);
		return pagination;
	}

	@Override
	public OrderTable gainOrderByOID(Integer paramInteger) {
		// TODO Auto-generated method stub
		OrderTable gainOrderByOID = orderDao.gainOrderByOID(paramInteger);

		return gainOrderByOID;
	}

	@Override
	public Integer gainMaxOrderId() {
		// TODO Auto-generated method stub
		return orderDao.gainMaxOrderId();
	}

	@Override
	public boolean deleteOrderByOID(Integer paramInteger) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrderByOID(paramInteger);
	}

	@Override
	public boolean saveOrder(OrderTable paramOrderTable) {
		// TODO Auto-generated method stub
		return orderDao.saveOrder(paramOrderTable);
	}

	@Override
	public boolean updateOrder(OrderTable paramOrderTable) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(paramOrderTable);
	}

}
