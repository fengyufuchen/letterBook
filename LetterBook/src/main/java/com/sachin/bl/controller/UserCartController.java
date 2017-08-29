package com.sachin.bl.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.bl.entities.BookTable;
import com.sachin.bl.entities.OrderContentTable;
import com.sachin.bl.entities.OrderTable;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.ShopCartContentTable;
import com.sachin.bl.entities.UserTable;
import com.sachin.bl.pojo.AjaxObject;
import com.sachin.bl.service.OrderContentService;
import com.sachin.bl.service.OrderService;
import com.sachin.bl.service.ShopCartContentService;
import com.sachin.bl.service.ShopCartService;

@Controller
public class UserCartController {
	@Autowired
	private ShopCartService shopCartService;
	@Autowired
	private ShopCartContentService shopCartContentService;

	@Autowired
	private OrderContentService orderContentService;
	@Autowired

	private OrderService orderService;

	@RequestMapping(value = "/userShopcar/shopcarContentManagerPage")

	public String getShopcarContentManagerPage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer numPerPage,
			String orderField, String orderDirection) {

		Integer scid = -1;

		UserTable use = (UserTable) request.getSession().getAttribute("User");
		if (shopCartService.getShopcarByUid(use.getUid()) != null) {
			scid = shopCartService.getShopcarByUid(use.getUid()).getScid();
		}
		Map param = new HashMap();
		param.put("scid", scid);
		param.put("pageSize", numPerPage);
		param.put("pageNum", pageNum);
		param.put("orderField", orderField);
		param.put("orderDirection", orderDirection);

		Pagination<ShopCartContentTable> page = new Pagination();
		page = shopCartContentService.getListShopcarContentPage(param);

		request.setAttribute("page", page);
		request.setAttribute("orderField", orderField);
		request.setAttribute("orderDirection", orderDirection);

		// 返回分页显示的插件，该方法主要是提供 商品数据信息
		return "/user/shopcarManager/managerShopcarContent";
	}

	/**
	 * 处理结算请求
	 * 
	 * @param request
	 * @param response
	 * @param pageNum
	 * @param numPerPage
	 * @param orderField
	 * @param orderDirection
	 * @return
	 */
	@RequestMapping(value = "/userShopcar/shopcarContentCount")

	public String shopcarContentCount(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer numPerPage,
			String orderField, String orderDirection) {

		Integer scid = -1;

		UserTable use = (UserTable) request.getSession().getAttribute("User");
		if (shopCartService.getShopcarByUid(use.getUid()) != null) {
			scid = shopCartService.getShopcarByUid(use.getUid()).getScid();
		}
		Map param = new HashMap();
		param.put("scid", scid);
		param.put("pageSize", numPerPage);
		param.put("pageNum", pageNum);
		param.put("orderField", orderField);
		param.put("orderDirection", orderDirection);

		Pagination<ShopCartContentTable> page = new Pagination();

		// 对应的购物车内的商品详情
		page = shopCartContentService.getListShopcarContentPage(param);// 根据购物车id获取
		List<ShopCartContentTable> content = page.getContent();

		float oprice = 0.0f;

		for (ShopCartContentTable shopCartContentTable : content) {

			oprice += shopCartContentTable.getNumber().intValue() * shopCartContentTable.getBook().getBoprice();
		}
		request.setAttribute("page", page);
		request.setAttribute("oprict", oprice);

		return "/user/shopcarManager/shopcarContentCount";

	}

	/**
	 * 一个用户有一个购物车记录（shopcart），这个shopcat中有多个contentItem。
	 * 每一item是shopcartContent，记录商品的书名，商品的数量。
	 * 当用户提交订单的时候取出购物车（根据用户id），然后获取得到详细记录，遍历每一个记录。
	 * 对这些记录按照商家（Business进行分类），每一个商家创建一个OrderTable。每一种树创建一个OrderContentTable
	 * 
	 * 一个OrderContentTable 表示用户在这个商家店内购买的各种书籍的总和。 比如说 book1 business1 book2
	 * business1 book3 business1
	 * 
	 * book4 business2 book5 business2 book6 business2
	 * 
	 * 这是一个订单，但是对应着有两个OrderTable，每一个OrderTable有三个OrderContentTable，表示用户从两个商家购买了书籍。
	 * 
	 * 处理完用户的shopCart之后清空这个shopCart 表示本次购物结束。
	 * 
	 * @param request
	 * @param response
	 * @param pageNum
	 * @param numPerPage
	 * @param orderField
	 * @param orderDirection
	 * @return
	 */
	@RequestMapping(value = "/userShopcar/summitOrder")
	@ResponseBody
	public AjaxObject submitOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer numPerPage,
			String orderField, String orderDirection) {
		UserTable user = (UserTable) request.getSession().getAttribute("User");
		Integer scid = -1;
		if (shopCartService.getShopcarByUid(user.getUid()) != null) {
			scid = shopCartService.getShopcarByUid(user.getUid()).getScid();
		}

		Map param = new HashMap();
		param.put("scid", scid);
		param.put("pageNum", pageNum);
		param.put("pageSize", numPerPage);
		param.put("orderField", orderField);
		param.put("orderDirection", orderDirection);

		String oname = request.getParameter("oname");
		String ophone = request.getParameter("ophone");
		String oadr = request.getParameter("oadr");

		Pagination<ShopCartContentTable> page = new Pagination<>();

		// 获取购物车对应的商品,需要根据用户的购物车的scid

		page = shopCartContentService.getListShopcarContentPage(param);

		List<ShopCartContentTable> content = page.getContent();
		Map<Integer, OrderTable> ord = new HashMap<>();

		/*
		 * 对每一个商品item 分business处理，不同的business会收到不同的订单
		 */
		for (ShopCartContentTable shopCartContentTable : content) {

			if (ord.containsKey(shopCartContentTable.getBook().getBusiness().getBid())) {
				// 同一个Business商家。 价格累加，增加一条OrderContentTable记录

				OrderTable ordertable = ord.get(shopCartContentTable.getBook().getBusiness().getBid());
				ordertable.setOprice(ordertable.getOprice()
						+ shopCartContentTable.getNumber() * shopCartContentTable.getBook().getBoprice());

				OrderContentTable orderContentTable = new OrderContentTable();
				orderContentTable.setBookTable(shopCartContentTable.getBook());
				orderContentTable.setNumber(shopCartContentTable.getNumber());
				orderContentTable.setOrderTable(ordertable);

				orderContentService.saveOrderContent(orderContentTable);
				ord.put(shopCartContentTable.getBook().getBusiness().getBid(), ordertable);

			} else {
				// 另外一个商家 得到的订单
				OrderTable orderTable = new OrderTable();
				orderTable.setUserTable(user);
				orderTable.setBusinessTable(shopCartContentTable.getBook().getBusiness());
				orderTable.setCreatetime(new Timestamp(System.currentTimeMillis()));
				orderTable.setEnabled(1);
				orderTable.setOadr(oadr);
				orderTable.setOname(oname);
				orderTable.setOphone(ophone);
				orderTable.setOphone(ophone);
				orderTable.setOprice(shopCartContentTable.getNumber() * shopCartContentTable.getBook().getBoprice());
				orderTable.setOstate(Integer.valueOf(2));
				orderService.saveOrder(orderTable);

				// 用户在这个商家店内购买的商品的 详细记录

				OrderContentTable orderContentTable = new OrderContentTable();

				orderContentTable.setOrderTable(orderTable);
				orderContentTable.setNumber(shopCartContentTable.getNumber());
				orderContentTable.setBookTable(shopCartContentTable.getBook());

				orderContentService.saveOrderContent(orderContentTable);

				// 将这个商家的订单ordertable 放入到map中
				ord.put(orderTable.getBusinessTable().getBid(), orderTable);

			}

		}

		AjaxObject ajaxObject = new AjaxObject();
		// 清空用户购物车
		if (shopCartService.deleteShopcarByScID(scid)) {
			ajaxObject.setMessage("订单提交成功!");
			ajaxObject.setStatusCode(200);
			ajaxObject.setCallbackType("closeCurrent");
			ajaxObject.setDialog("true");

		} else {
			ajaxObject.setMessage("订单提交失败！");
			ajaxObject.setStatusCode(300);
			ajaxObject.setCallbackType("closeCurrent");

		}
		return ajaxObject;
	}

	@RequestMapping(value = "/userShopcar/updateShopcarContent")
	@ResponseBody
	public AjaxObject updateShopcarContent(ShopCartContentTable shopcarContent) throws Exception {

		BookTable bok = shopCartContentService.getShopcarContentBySccId(shopcarContent.getSccid()).getBook();
		AjaxObject ajaxObject = new AjaxObject();
		if (shopcarContent.getNumber() > bok.getBoamount().intValue()) {

			ajaxObject.setMessage("操作失败，库存不足!");
			ajaxObject.setStatusCode(300);
			ajaxObject.setCallbackType("closeCurrent");
			// ajaxObject.setDialog("true");

			return ajaxObject;

		}

		if (shopCartContentService.updateShopcarContent(shopcarContent)) {
			ajaxObject.setMessage("修改成功!");
			ajaxObject.setStatusCode(200);
			// ajaxObject.setDialog("true");
			ajaxObject.setCallbackType("closeCurrent");

		} else {
			ajaxObject.setMessage("操作失败!");
			ajaxObject.setStatusCode(300);
			// ajaxObject.setDialog("true");

			ajaxObject.setCallbackType("closeCurrent");

		}
		return ajaxObject;
	}

	@RequestMapping(value = "/userShopcar/deleteShopcarContent")

	@ResponseBody
	public AjaxObject deleteShopcarContent(HttpServletRequest request) throws Exception {
		Integer sccid = Integer.valueOf(request.getParameter("sccid"));
		AjaxObject ajaxObject = new AjaxObject();

		if (shopCartContentService.deleteShopcarContentBySccID(sccid)) {
			ajaxObject.setMessage("删除成功!");
			ajaxObject.setStatusCode(200);
			// ajaxObject.setDialog("true");
			ajaxObject.setCallbackType("");

		} else {
			ajaxObject.setMessage("删除失败!");
			ajaxObject.setStatusCode(300);
			// ajaxObject.setDialog("false");
			ajaxObject.setCallbackType("");
		}

		return ajaxObject;
	}

	@RequestMapping(value = "/userShopcar/editShopcarContent")
	public String editShopcarContent(HttpServletRequest request) throws Exception {
		Integer sccid = Integer.valueOf(request.getParameter("sccid"));
		ShopCartContentTable shopc = shopCartContentService.getShopcarContentBySccId(sccid);
		request.setAttribute("shopcarContent", shopc);
		return "/user/shopcarManager/updateShopcarContent";
	}

	/*
	 * @RequestMapping(value = "/userShopcar/shopcarContentCount") public String
	 * getshopcarContentCount(HttpServletRequest
	 * request, @RequestParam(defaultValue = "1") Integer pageNum,
	 * 
	 * @RequestParam(defaultValue = "10") Integer numPerPage, String orderField,
	 * String orderDirection) throws Exception {
	 * 
	 * HttpSession session = request.getSession(); Integer scid = -1; UserTable
	 * use = (UserTable) session.getAttribute("User"); if
	 * (shopCartService.getShopcarByUid(use.getUid()) != null) { scid =
	 * shopCartService.getShopcarByUid(use.getUid()).getScid(); } Map param =
	 * new HashMap(); param.put("scid", scid); param.put("pageSize",
	 * numPerPage); param.put("pageNum", pageNum); param.put("orderField",
	 * orderField); param.put("orderDirection", orderDirection);
	 * 
	 * Pagination<ShopCartContentTable> page = new Pagination(); page =
	 * shopCartContentService.getListShopcarContentPage(param);
	 * List<ShopCartContentTable> shopcarContentTables = page.getContent();
	 * 
	 * float oprice = 0.0F; for (int i = 0; i < shopcarContentTables.size();
	 * i++) { oprice += ((ShopCartContentTable)
	 * shopcarContentTables.get(i)).getNumber().intValue()
	 * ((ShopCartContentTable)
	 * shopcarContentTables.get(i)).getBook().getBoprice(); }
	 * request.setAttribute("page", page); request.setAttribute("oprice",
	 * Float.valueOf(oprice)); return
	 * "/user/shopcarManager/shopcarContentCount"; }
	 */

}
