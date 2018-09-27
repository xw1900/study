package com.xw.mybatis.search;

import java.io.Serializable;

public class RequestSearchVO implements Serializable {
	private int pageNum;
	private int pageSize;
	private String orderBy;

	public RequestSearchVO() {
	}

	public int getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
}
