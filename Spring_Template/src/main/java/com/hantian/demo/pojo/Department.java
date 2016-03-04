package com.hantian.demo.pojo;

/**
 * @ClassName: Department
 * @Description: TODO
 * @author maybo
 * @date 2016年3月2日 上午11:22:31
 *
 */
public class Department extends BaseObject {
	private String name;// 部门名字
	private String description;// 部门描述
	private Department parent;// 上级部门

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", description=" + description
				+ ", parent=" + parent + "]";
	}

}
