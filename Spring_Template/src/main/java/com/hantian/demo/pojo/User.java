package com.hantian.demo.pojo;

/**
 * @ClassName: User
 * @Description: TODO
 * @author maybo
 * @date 2016年3月2日 上午11:16:33
 *
 */
public class User extends BaseObject {
	private String name;// 用户名字
	private long workNumber;// 用户工号
	private String email;// 邮箱
	private String phone; // 电话
	private String sex;// 性别
	private Department department=new Department();// 所属部门
	private String position;// 职位
	private int status;// 状态

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(long workNumber) {
		this.workNumber = workNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", workNumber=" + workNumber + ", email="
				+ email + ", phone=" + phone + ", sex=" + sex + ", department="
				+ department + ", position=" + position + ", status=" + status
				+ "]";
	}

}
