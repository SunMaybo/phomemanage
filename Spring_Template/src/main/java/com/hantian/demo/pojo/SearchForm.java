package com.hantian.demo.pojo;

public class SearchForm {
private int page;
private int totals;
private int pageSize;
private int pageTotals;
private String key;
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getTotals() {
	return totals;
}
public void setTotals(int totals) {
	this.totals = totals;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getPageTotals() {
	return pageTotals;
}
public void setPageTotals(int pageTotals) {
	this.pageTotals = pageTotals;
}
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
@Override
public String toString() {
	return "SearchForm [page=" + page + ", totals=" + totals + ", pageSize="
			+ pageSize + ", pageTotals=" + pageTotals + ", key=" + key + "]";
}

}
