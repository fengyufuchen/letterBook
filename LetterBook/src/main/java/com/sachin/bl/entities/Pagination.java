package com.sachin.bl.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<T> content = new ArrayList();

	private Integer numPerPage;
	private Integer currentPage;
	private Integer totalPageNum;
	private Integer totalCount;

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> cntent) {
		this.content = cntent;
	}

	public Integer getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(Integer totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void calculatePage() {
		if (this.totalCount == null || this.totalCount.intValue() < 1) {

			this.totalPageNum = Integer.valueOf(1);
			this.content = new ArrayList();
			this.currentPage = Integer.valueOf(1);
			this.totalCount = Integer.valueOf(0);

		} else {

			this.totalPageNum = this.totalCount % numPerPage == 0 ? this.totalCount / numPerPage
					: this.totalCount / numPerPage + 1;
		}

	}
}
