package com.sachin.bl.dao;

import com.sachin.bl.entities.AdminTable;

public interface AdminDao {

	void modifyPassword(AdminTable adminTable, String newPassword);

	AdminTable gainAdminTableByName(String paramString);

	AdminTable getAdminByAid(Integer aid);

}
