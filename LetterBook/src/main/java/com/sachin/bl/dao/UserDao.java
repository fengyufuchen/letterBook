package com.sachin.bl.dao;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.UserTable;

public interface UserDao {
	public abstract List<UserTable> getListUserPage(Map paramMap);

	public abstract UserTable gainUserByAccount(String paramString);

	public abstract void modifyPassword(UserTable paramUserTable, String paramString) throws Exception;

	public abstract Integer getListUserCount(Map paramMap);

	public abstract boolean deleteUserByUid(Integer paramInteger);

	public abstract boolean saveUser(UserTable paramUserTable);

	public abstract boolean updateUser(UserTable paramUserTable);

	public abstract UserTable getUserByUid(Integer paramInteger);

	public abstract List<UserTable> getAllUser();
}
