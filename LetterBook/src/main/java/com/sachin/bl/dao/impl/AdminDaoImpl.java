package com.sachin.bl.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sachin.bl.dao.AdminDao;
import com.sachin.bl.entities.AdminTable;

@Repository
@Transactional
public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {

	@Override
	public void modifyPassword(AdminTable adminTable, String newPassword) {
		// TODO Auto-generated method stub

		String hql = "update AdminTable set apsw= :apswN where aid=:aidN";

		Query modifyPs = this.getSession().createQuery(hql);
		modifyPs.setString("apswN", adminTable.getAname());
		modifyPs.setString("aidN", newPassword);

		modifyPs.executeUpdate();

	}

	@Override
	public AdminTable gainAdminTableByName(String name) {

		// TODO Auto-generated method stub
		String hql = " from AdminTable where aname=?";

		List<AdminTable> adList = (List<AdminTable>) this.hibernateTemplate.find(hql, name);
		if (adList.size() == 0)
			return null;
		return adList.get(0);

	}

	@Override
	public AdminTable getAdminByAid(Integer aid) {
		// TODO Auto-generated method stub
		String hql = "from AdminTable where aid=?";

		List<AdminTable> adList = (List<AdminTable>) this.hibernateTemplate.find(hql, aid);

		try {
			return adList.get(0);
		} catch (Exception e) {
			return null;

		}

	}

}
