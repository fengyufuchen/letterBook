package com.sachin.bl.service;

import java.util.Map;

import com.sachin.bl.entities.BusinessTable;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.exception.TipException;

public interface BusinessService {
	public abstract Pagination<BusinessTable> getListBusinessPage(Map paramMap);

	public abstract void modifyPassword(BusinessTable paramBusinessTable, String paramString1, String paramString2)
			throws Exception;

	public abstract BusinessTable getBusinessByBid(Integer paramInteger);

	public abstract boolean isBusinessexist(BusinessTable paramBusinessTable);

	public abstract boolean saveBusiness(BusinessTable paramBusinessTable);

	public abstract boolean deleteBusinessByBid(Integer paramInteger);

	public abstract boolean updateBusiness(BusinessTable paramBusinessTable) throws TipException;
}
