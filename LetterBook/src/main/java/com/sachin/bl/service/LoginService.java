package com.sachin.bl.service;

import java.util.Map;

public interface LoginService {

	public abstract Map<String, Object> login(String paramString1, String paramString2, int paramInt) throws Exception;

	public abstract Map<String, Object> userlogin(String paramString1, String paramString2, int paramInt)
			throws Exception;

	public abstract Map<String, Object> businesslogin(String paramString1, String paramString2, int paramInt)
			throws Exception;
}
