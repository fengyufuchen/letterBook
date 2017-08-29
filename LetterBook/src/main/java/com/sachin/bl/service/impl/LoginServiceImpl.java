package com.sachin.bl.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.bl.dao.UserDao;
import com.sachin.bl.entities.UserTable;
import com.sachin.bl.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> login(String paramString1, String paramString2, int paramInt) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> userlogin(String username, String password, int userId) throws Exception {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<>();
		UserTable user = this.userDao.gainUserByAccount(username);
		if (user == null) {
			map.put("msg", "输入有误，请重新输入");
		} else if (user.getEnabled().intValue() == 0) {
			map.put("msg", "账号不可用");
		} else if ((password == "") && (user.getUpsw() == null) || (password.equals(user.getUpsw()))) {
			map.put("User", user);
		} else {
			map.put("msg", "账号输入有误，请重新输入！");
		}

		return map;
	}

	@Override
	public Map<String, Object> businesslogin(String paramString1, String paramString2, int paramInt) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
