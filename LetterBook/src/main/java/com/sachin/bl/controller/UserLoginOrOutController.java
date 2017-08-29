package com.sachin.bl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.bl.pojo.SachinResult;
import com.sachin.bl.service.LoginService;

@Controller
public class UserLoginOrOutController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/user/login")
	@ResponseBody
	public SachinResult userLogin(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Map<String, Object> map = new HashMap<>();

		try {
			if (StringUtils.isEmpty(username)) {
				return SachinResult.build(400, map.get("msg").toString());
			}

			map = loginService.userlogin(username, password, 0);
			Object object = map.get("User");
			if (object != null) {

				session.setAttribute("User", object);
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {

				}
				return SachinResult.ok();

			} else {

				session.setAttribute("User", null);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

		return SachinResult.build(400, map.get("msg")!=null? map.get("msg").toString():"");

	}

	@RequestMapping(value = "/user/toregister")
	public String userToRegister() {

		return "register";
	}

	@RequestMapping(value = "/user/userIndex")
	public String userIndex() {
		return "/user/userIndex";
	}

	@RequestMapping(value = "/user/logout")
	public String UserLoginOut(HttpServletRequest request)

			throws Exception {
		request.getSession().setAttribute("User", null);

		return "/login";
	}

}
