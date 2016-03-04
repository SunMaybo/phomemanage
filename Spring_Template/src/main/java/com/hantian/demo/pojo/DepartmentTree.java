package com.hantian.demo.pojo;

import java.util.ArrayList;
import java.util.List;

public class DepartmentTree {
	private int id;
	private String title;
	private String key;
	private boolean isFolder;
	private boolean isLazy;
	private List<DepartmentTree> children=new ArrayList<DepartmentTree>();

	public void setChildren(List<DepartmentTree> children) {
		this.children = children;
	}

	public List<DepartmentTree> getChildren() {
		return children;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isFolder() {
		return isFolder;
	}

	public void setFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}

	public boolean isLazy() {
		return isLazy;
	}

	public void setLazy(boolean isLazy) {
		this.isLazy = isLazy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "DepartmentTree [id=" + id + ", title=" + title + ", key=" + key
				+ ", isFolder=" + isFolder + ", isLazy=" + isLazy
				+ ", children=" + children + "]";
	}


}
