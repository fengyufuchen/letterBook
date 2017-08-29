package com.sachin.bl.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.bl.entities.UserTable;
import com.sachin.bl.pojo.AjaxObject;
import com.sachin.bl.service.UserService;



@Controller
public class UserController {

	@Autowired
	private UserService userService;

	private static final Log log = LogFactory.getLog(UserController.class);

	@RequestMapping(value = "/user/editUser")
	public String editUser(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		UserTable user = (UserTable) session.getAttribute("User");

		request.setAttribute("user", user);
		return "/user/updateInfo";
	}

	@RequestMapping(value = "/user/updateUser")
	@ResponseBody
	public AjaxObject updateUser(UserTable user, HttpServletRequest request) {

		AjaxObject ajaxResult = new AjaxObject();
		if (userService.updateUser(user)) {

			request.getSession().setAttribute("User", user);
			ajaxResult.setDialog("true");
			ajaxResult.setMessage("修改成功");
			ajaxResult.setStatusCode(200);
		} else {
			ajaxResult.setDialog("true");
			ajaxResult.setMessage("修改失败");
			ajaxResult.setStatusCode(300);
		}
		// this.callbackType = "closeCurrent";
		return ajaxResult;
	}

	@RequestMapping(value = "/user/chpwd")
	public String modelModifyPswDialog() {

		return "/user/chpwd";
	}

	@RequestMapping(value = "/user/updateUserPwd")
	public AjaxObject modifyUserPsw(String oldPwd, String newPwd, String rnewPassword, HttpServletRequest request,
			HttpServletResponse response) {
		AjaxObject ajaxResult = new AjaxObject();
		HttpSession session = request.getSession();
		UserTable user = (UserTable) session.getAttribute("User");

		if (user == null) {
			try {
				ajaxResult.setDialog("true");
				ajaxResult.setStatusCode(300);
				response.sendRedirect("/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ajaxResult;
		}

		if (StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(rnewPassword) || StringUtils.isEmpty(rnewPassword)
				|| !newPwd.equals(rnewPassword)) {
			ajaxResult.setMessage("输入有误");
			ajaxResult.setStatusCode(300);
			ajaxResult.setDialog("true");

			return ajaxResult;
		}

		UserTable userByUid = userService.getUserByUid(user.getUid());
		userByUid.setUpsw(newPwd);
		boolean saveUser = false;
		try {
			saveUser = userService.saveUser(userByUid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ajaxResult.setMessage("更新出错！");
			ajaxResult.setStatusCode(300);
			ajaxResult.setDialog("true");

			return ajaxResult;
		}
		ajaxResult.setMessage("更新成功！");
		ajaxResult.setStatusCode(200);
		ajaxResult.setDialog("true");
		ajaxResult.setForwardUrl("/");
		ajaxResult.setCallbackType("forward");
		request.getSession().setAttribute("User", null);

		return ajaxResult;
	}

}
