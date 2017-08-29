package com.sachin.bl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.bl.entities.BookTable;
import com.sachin.bl.entities.CommentTable;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.ShopCartContentTable;
import com.sachin.bl.entities.ShopCartTable;
import com.sachin.bl.entities.UserTable;
import com.sachin.bl.pojo.AjaxObject;
import com.sachin.bl.service.BookService;
import com.sachin.bl.service.CommentService;
import com.sachin.bl.service.ShopCartContentService;
import com.sachin.bl.service.ShopCartService;

@Controller
public class UserBookController {
	public static final Integer PAGE_SIZE = Integer.valueOf(10);
	@Autowired
	private BookService bookService;
	@Autowired
	private ShopCartService shopCartService;

	@Autowired
	private ShopCartContentService shopCartContentService;
	@Autowired
	private CommentService commentService;

	/*
	 * pageNum:1 numPerPage: orderField: orderDirection: condition.boname:金瓶梅
	 * condition.boauthor:
	 */
	@RequestMapping(value = "/user/bookspage")
	private String getBookPage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer numPerPage,
			BookTable condition, String orderField, String orderDirection) {
		/*
		 * this.orderField = ((this.orderField == null) ||
		 * ("".equals(this.orderField)) ? "boamount" : this.orderField);
		 * this.orderDirection = ((this.orderDirection == null) ||
		 * ("".equals(this.orderDirection)) ? "desc" : this.orderDirection);
		 */

		Map param = new HashMap();
		// param.put("uid", use.getUid());
		param.put("pageSize", numPerPage);
		param.put("pageNum", pageNum);

		param.put("condition", condition);

		Pagination<BookTable> listBookPage = bookService.getListBookPage(param);
		request.setAttribute("page", listBookPage);
		request.setAttribute("orderField", orderField);
		request.setAttribute("orderDirection", orderDirection);

		return "/user/bookManager/managerBook";

	}

	@RequestMapping(value = "/userBook/checkBook")
	private String checkBook(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1") Integer boid) {
		/*
		 * this.orderField = ((this.orderField == null) ||
		 * ("".equals(this.orderField)) ? "boamount" : this.orderField);
		 * this.orderDirection = ((this.orderDirection == null) ||
		 * ("".equals(this.orderDirection)) ? "desc" : this.orderDirection);
		 */

		BookTable bok = bookService.getBookByBoID(boid);
		request.setAttribute("book", bok);
		return "/user/bookManager/checkBook";

	}

	@RequestMapping(value = "/userBook/getCommentByBoidPage")
	private String getCommentByBoidPage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1") Integer boid, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, String orderField, String orderDirection) {
		/*
		 * this.orderField = ((this.orderField == null) ||
		 * ("".equals(this.orderField)) ? "boamount" : this.orderField);
		 * this.orderDirection = ((this.orderDirection == null) ||
		 * ("".equals(this.orderDirection)) ? "desc" : this.orderDirection);
		 */
		Map<String, Object> map = new HashMap<>();
		map.put("boid", boid);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("orderField", orderField);
		map.put("orderDirection", orderDirection);

		Pagination<CommentTable> page = commentService.getCommentPageByBoid(map);

		request.setAttribute("page", page);
		request.setAttribute("orderField", orderField);
		request.setAttribute("orderDirection", orderDirection);
		return "/user/bookManager/checkComment";

	}

	@RequestMapping(value = "/userBook/addBookShopcar")
	@ResponseBody
	private AjaxObject addBookShopcar(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1") Integer boid) {

		AjaxObject ajaxResult = new AjaxObject();

		HttpSession session = request.getSession();
		BookTable bok = bookService.getBookByBoID(boid);
		if (bok.getBoamount().intValue() <= 0) {

			ajaxResult.setMessage("添加失败，售罄!");
			ajaxResult.setStatusCode(300);
			ajaxResult.setCallbackType("closeCurrent");
			/*
			 * this.message = "添加失败，售罄！"; this.statusCode = "300";
			 * this.callbackType = "closeCurrent";
			 */
		} else {
			UserTable use = (UserTable) session.getAttribute("User");
			ShopCartTable shopcar = shopCartService.getShopcarByUid(use.getUid());
			ShopCartContentTable shopcarContent = null;
			if (shopcar != null) {
				shopcarContent = shopCartContentService.getShopcarContentByScIdAndBoId(shopcar.getScid(),
						bok.getBoid());
				if (shopcarContent != null) {
					shopcarContent.setNumber(Integer.valueOf(shopcarContent.getNumber().intValue() + 1));
					shopCartContentService.updateShopcarContent(shopcarContent);
				} else {
					shopcarContent = new ShopCartContentTable();
					shopcarContent.setShopcar(shopcar);
					shopcarContent.setBook(bok);
					shopcarContent.setNumber(Integer.valueOf(1));
					shopCartContentService.saveShopcarContent(shopcarContent);
				}
				ajaxResult = new AjaxObject();
				ajaxResult.setMessage("添加成功!");
				ajaxResult.setStatusCode(200);
				ajaxResult.setCallbackType("closeCurrent");
				ajaxResult.setDialog("true");
				/*
				 * this.message = "����������"; this.statusCode = "200";
				 * this.callbackType = "closeCurrent"; this.dialog = "true";
				 */
			} else if (shopcar == null) {
				shopcar = new ShopCartTable();
				shopcar.setUserTable(use);
				shopcar.setEnabled(Integer.valueOf(1));
				shopCartService.saveShopcar(shopcar);

				shopcarContent = new ShopCartContentTable();
				shopcarContent.setShopcar(shopcar);
			
				shopcarContent.setBook(bok);
				shopcarContent.setNumber(Integer.valueOf(1));
				shopCartContentService.saveShopcarContent(shopcarContent);
				ajaxResult = new AjaxObject();
				ajaxResult.setMessage("添加成功!");
				ajaxResult.setStatusCode(200);
				ajaxResult.setCallbackType("closeCurrent");
				ajaxResult.setDialog("true");
			}
		}

		return ajaxResult;
	}

}
