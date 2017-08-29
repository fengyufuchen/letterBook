package com.sachin.bl.service;

import java.util.Map;

import com.sachin.bl.entities.Pagination;
import com.sachin.bl.entities.UserTable;
import com.sachin.bl.exception.TipException;

public interface UserService {

	public abstract Pagination<UserTable> getListUserPage(Map paramMap);

	public abstract void modifyPassword(UserTable paramUserTable, String paramString1, String paramString2)
			throws Exception;

	public abstract UserTable getUserByUid(Integer paramInteger);

	public abstract boolean isUserexist(UserTable paramUserTable);

	public abstract boolean saveUser(UserTable paramUserTable);

	public abstract boolean deleteUserByUid(Integer paramInteger);

	public abstract boolean updateUser(UserTable paramUserTable) ;
}
