package com.sachin.bl.service.impl;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.bl.dao.UserDao;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.UserTable;
import com.sachin.bl.exception.TipException;
import com.sachin.bl.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Pagination<UserTable> getListUserPage(Map paramMap) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void modifyPassword(UserTable paramUserTable, String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserTable getUserByUid(Integer paramInteger) {
		// TODO Auto-generated method stub

		UserTable userByUid = userDao.getUserByUid(paramInteger);

		return userByUid;
	}

	@Override
	public boolean isUserexist(UserTable paramUserTable) {
		// TODO Auto-generated method stub
		UserTable user = userDao.gainUserByAccount(paramUserTable.getUaccount());

		if (user == null)
			return false;
		return true;
	}

	@Override
	public boolean saveUser(UserTable paramUserTable) {
		// TODO Auto-generated method stub
		/*
		 * String uaccount = request.getParameter("uaccount"); String uname =
		 * request.getParameter("uname"); String usex =
		 * request.getParameter("usex"); String upsw =
		 * request.getParameter("upsw"); String uphone =
		 * request.getParameter("uphone"); String uemail =
		 * request.getParameter("uemail"); String uadr =
		 * request.getParameter("uadr");
		 */

		paramUserTable.setCreatetime(new Timestamp(System.currentTimeMillis()));
		paramUserTable.setEnabled(1);
		paramUserTable.setUpdatetime(new Timestamp(System.currentTimeMillis()));

		boolean saveUser = userDao.saveUser(paramUserTable);

		return saveUser;
	}

	@Override
	public boolean deleteUserByUid(Integer paramInteger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(UserTable paramUserTable) {
		// TODO Auto-generated method stub
		UserTable userByUid = userDao.getUserByUid(paramUserTable.getUid());
		userByUid.setUadr(paramUserTable.getUadr());
		userByUid.setUname(paramUserTable.getUname());
		userByUid.setUemail(paramUserTable.getUemail());

		return true;
	}

}
