package com.green.phonemanage.model;

/**
 * @author maybo
 *
 */
public class SearchForm {
	public String key;// 关键字查询
	public int pageIndex; // 页数
	public int pageSize;// 每页３大小
	public String sortField;
	public String sortOrder;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public String toString() {
		return "SearchForm [key=" + key + ", pageIndex=" + pageIndex
				+ ", pageSize=" + pageSize + ", sortField=" + sortField
				+ ", sortOrder=" + sortOrder + "]";
	}

}
