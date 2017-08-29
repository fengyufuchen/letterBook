package com.sachin.bl.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.bl.entities.UserTable;
import com.sachin.bl.pojo.SachinResult;
import com.sachin.bl.service.UserService;

@Controller
public class UserRegisterController {

	@Autowired
	private UserService userSerivce;

	@RequestMapping(value = "/user/register")
	@ResponseBody
	public SachinResult registerUser(HttpServletRequest request, HttpServletResponse response) {
		String uaccount = request.getParameter("uaccount");
		String uname = request.getParameter("uname");
		String usex = request.getParameter("usex");
		String upsw = request.getParameter("upsw");
		String uphone = request.getParameter("uphone");
		String uemail = request.getParameter("uemail");
		String uadr = request.getParameter("uadr");

		UserTable user = new UserTable();
		user.setUaccount(uaccount);
		user.setUname(uname);
		user.setUpsw(upsw);
		user.setUsex(usex);
		user.setUadr(uadr);
		user.setUphone(uphone);
		user.setUemail(uemail);
		user.setEnabled(Integer.valueOf(1));

		SachinResult sachinResult = new SachinResult();

		if (userSerivce.isUserexist(user)) {

			sachinResult.setMsg("账号已经存在");
			sachinResult.setStatus(300);

		} else if (userSerivce.saveUser(user)) {
			sachinResult.setMsg("注册成功");
			sachinResult.setStatus(200);

		} else {

			sachinResult.setMsg("信息填写错误");
			sachinResult.setStatus(300);
		}

		// 如果注册失败那么就重新返回注册页面
		return sachinResult;
	}

}
