package com.sachin.bl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.bl.entities.OrderContentTable;
import com.sachin.bl.entities.OrderTable;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.UserTable;
import com.sachin.bl.pojo.AjaxObject;
import com.sachin.bl.service.OrderContentService;
import com.sachin.bl.service.OrderService;

@Controller
public class UserOrderController {

	@Autowired
	private OrderService orderService;

	@Autowired

	private OrderContentService orderContentService;

	@RequestMapping(value = "/userOrder/ordersPage")
	public String getOrderPage(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer numPerPage, String orderField, String orderDirection)
			throws Exception {
		String pageNumStr = request.getParameter("pageNum");
		String numPerPageStr = request.getParameter("numPerPage");

		UserTable use = (UserTable) request.getSession().getAttribute("User");

		Map param = new HashMap();
		param.put("uid", use.getUid());
		param.put("pageSize", numPerPage);
		param.put("pageNum", pageNum);
		param.put("orderField", orderField);
		param.put("orderDirection", orderDirection);

		Pagination<OrderTable> page = new Pagination();

		page = this.orderService.getListOrderPageByUid(param);
		System.out.println(page.toString());
		request.setAttribute("page", page);
		request.setAttribute("orderField", orderField);
		request.setAttribute("orderDirection", orderDirection);
		return "/user/orderManager/managerOrder";
	}

	@RequestMapping(value = "/userOrder/orderContentPage")

	public String getOrderContentPage(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer numPerPage, String orderField, String orderDirection) {

		Integer oid = Integer.valueOf(request.getParameter("oid"));

		Map param = new HashMap();
		param.put("oid", oid);
		param.put("pageSize", numPerPage);
		param.put("pageNum", pageNum);
		param.put("orderField", orderField);
		param.put("orderDirection", orderDirection);

		Pagination<OrderContentTable> page = new Pagination();
		page = orderContentService.getListOrderContentPage(param);

		request.setAttribute("page", page);
		request.setAttribute("orderField", orderField);
		request.setAttribute("orderDirection", orderDirection);
		return "/user/orderManager/managerOrderContent";
	}

	@RequestMapping(value = "/userOrder/editOrder")

	public String editOrder(HttpServletRequest request) throws Exception {
		Integer oid = Integer.valueOf(request.getParameter("oid"));
		OrderTable ord = orderService.gainOrderByOID(oid);
		request.setAttribute("order", ord);
		return "/user/orderManager/updateOrder";
	}

	@RequestMapping(value = "/userOrder/updateOrder")
	@ResponseBody
	public AjaxObject updateOrder(OrderTable order) throws Exception {

		System.out.println(order.toString());
		OrderTable ord = orderService.gainOrderByOID(order.getOid());

		AjaxObject ajaxResult = new AjaxObject();

		ord.setOname(order.getOname());
		ord.setOphone(order.getOphone());
		ord.setOadr(order.getOadr());
		if (orderService.updateOrder(ord)) {
			ajaxResult.setMessage("更新成功");
			ajaxResult.setStatusCode(200);
			ajaxResult.setCallbackType("closeCurrent");
			ajaxResult.setDialog("true");

		} else {
			ajaxResult.setMessage("跟新失败");
			ajaxResult.setStatusCode(300);
			ajaxResult.setCallbackType("closeCurrent");

		}
		return ajaxResult;
	}

	@RequestMapping(value = "/userOrder/deleteOrder")
	@ResponseBody

	public AjaxObject deleteOrder(HttpServletRequest request) throws Exception {
		Integer oid = Integer.valueOf(request.getParameter("oid"));
		AjaxObject ajaxResult = new AjaxObject();
		if (orderService.deleteOrderByOID(oid)) {

			ajaxResult.setMessage("删除成功");
			ajaxResult.setStatusCode(200);
			// ajaxResult.setDialog("true");
		} else {
			ajaxResult.setMessage("删除失败");
			ajaxResult.setStatusCode(300);
			// ajaxResult.setDialog("true");
		}
		return ajaxResult;
	}

	@RequestMapping(value = "/userOrder/orderPage")

	public String refreshOrderPage(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer numPerPage, String orderField, String orderDirection) {
		
		
		String pageNumStr = request.getParameter("pageNum");
		String numPerPageStr = request.getParameter("numPerPage");

		UserTable use = (UserTable) request.getSession().getAttribute("User");

		Map param = new HashMap();
		param.put("uid", use.getUid());
		param.put("pageSize", numPerPage);
		param.put("pageNum", pageNum);
		param.put("orderField", orderField);
		param.put("orderDirection", orderDirection);

		Pagination<OrderTable> page = new Pagination();

		page = this.orderService.getListOrderPageByUid(param);
		System.out.println(page.toString());
		request.setAttribute("page", page);
		request.setAttribute("orderField", orderField);
		request.setAttribute("orderDirection", orderDirection);
		return "/user/orderManager/managerOrder";
		

	}

}
