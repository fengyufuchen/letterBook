package com.sachin.bl.dao;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.BusinessTable;

public interface BusinessDao {

	public abstract List<BusinessTable> getListBusinessPage(Map paramMap);

	public abstract BusinessTable getBusinessByAccount(String paramString);

	public abstract void modifyPassword(BusinessTable paramBusinessTable, String paramString) throws Exception;

	public abstract Integer getListBusinessCount(Map paramMap);

	public abstract boolean deleteBusinessByBid(Integer paramInteger);

	public abstract boolean saveBusiness(BusinessTable paramBusinessTable);

	public abstract boolean updateBusiness(BusinessTable paramBusinessTable);

	public abstract BusinessTable getBusinessByBid(Integer paramInteger);

	public abstract List<BusinessTable> getAllBusiness();

}
