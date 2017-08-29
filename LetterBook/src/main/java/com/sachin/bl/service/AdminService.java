package com.sachin.bl.service;

import com.sachin.bl.entities.AdminTable;

public interface AdminService {

	  public abstract void modifyPassword(AdminTable paramAdminTable, String paramString1, String paramString2)
	    throws Exception;
	  
	  public abstract AdminTable getAdminByAid(Integer paramInteger);
}
