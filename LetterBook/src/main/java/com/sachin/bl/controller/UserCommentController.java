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
import com.sachin.bl.entities.UserTable;
import com.sachin.bl.pojo.AjaxObject;
import com.sachin.bl.service.BookService;
import com.sachin.bl.service.CommentService;

@Controller
public class UserCommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/userComment/commentsPage")

	public String getCommentPage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer numPerPage,
			BookTable condition, String orderField, String orderDirection) throws Exception {

		HttpSession session = request.getSession();

		UserTable use = (UserTable) session.getAttribute("User");

		Map param = new HashMap();
		param.put("uid", use.getUid());
		param.put("pageSize", numPerPage);
		param.put("pageNum", pageNum);
		param.put("orderField", orderField);
		param.put("orderDirection", orderDirection);

		Pagination<CommentTable> page = new Pagination();
		page = commentService.getCommentPageByUid(param);

		request.setAttribute("page", page);
		request.setAttribute("orderField", orderField);
		request.setAttribute("orderDirection", orderDirection);
		return "/user/commentManager/managerComment";
	}

	@RequestMapping(value = "/userComment/editComment")

	public String editComment(HttpServletRequest request) throws Exception {
		Integer coid = Integer.valueOf(request.getParameter("coid"));
		CommentTable com = commentService.getCommentByCoId(coid);
		request.setAttribute("comment", com);
		return "/user/commentManager/updateComment";
	}

	@RequestMapping(value = "/userComment/addComment")

	public String addComment(HttpServletRequest request) throws Exception {
		Integer boid = Integer.valueOf(request.getParameter("boid"));
		request.setAttribute("boid", boid);
		return "/user/commentManager/addComment";
	}

	@RequestMapping("/userComment/saveComment")

	@ResponseBody

	public AjaxObject saveComment(HttpServletRequest request, CommentTable comment) throws Exception {
		UserTable use = (UserTable) request.getSession().getAttribute("User");
		AjaxObject ajaxResult = new AjaxObject();
		comment.setUser(use);
		Integer boid = Integer.valueOf(request.getParameter("boid"));
		BookTable bok = bookService.getBookByBoID(boid);
		comment.setBookTable(bok);
		String cocomment = request.getParameter("cocomment");
		comment.setCocomment(cocomment);
		comment.setCoreply("");
		comment.setEnabled(Integer.valueOf(1));
		if (commentService.saveComment(comment)) {
			ajaxResult.setMessage("保存成功");
			ajaxResult.setStatusCode(200);
			ajaxResult.setDialog("true");

		} else {
			ajaxResult.setMessage("保存失败");
			ajaxResult.setStatusCode(200);

			ajaxResult.setCallbackType("closeCurrent");

		}
		return ajaxResult;
	}

	@RequestMapping(value = "/userComment/updateComment")

	@ResponseBody
	public AjaxObject updateComment(CommentTable commentTable) throws Exception {
		AjaxObject ajaxResult = new AjaxObject();

		if (commentService.userupdateComment(commentTable)) {
			ajaxResult.setMessage("更新成功");
			ajaxResult.setStatusCode(200);
			ajaxResult.setDialog("true");
			ajaxResult.setCallbackType("closeCurrent");
		} else {
			ajaxResult.setMessage("更新失败");
			ajaxResult.setStatusCode(300);
			ajaxResult.setDialog("true");
			ajaxResult.setCallbackType("closeCurrent");
		}
		return ajaxResult;
	}

	@RequestMapping(value = "/userComment/deleteComment")
	@ResponseBody
	public AjaxObject deleteComment(HttpServletRequest request) throws Exception {
		Integer coid = Integer.valueOf(request.getParameter("coid"));
		AjaxObject ajaxResult = new AjaxObject();
		if (commentService.deleteCommentByCoID(coid)) {
			ajaxResult.setMessage("删除成功");
			ajaxResult.setStatusCode(200);
			ajaxResult.setDialog("true");
		} else {
			ajaxResult.setMessage("删除失败");
			ajaxResult.setStatusCode(300);
			ajaxResult.setDialog("false");

		}
		return ajaxResult;
	}

}
