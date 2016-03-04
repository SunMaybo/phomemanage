package com.green.phonemanage.model;

/**
 * @author maybo 用户实体类
 */
public class User {
	private int id;
	private String loginName;// 登录名
	private String passwd;// 密码
	private String name;// 用户名字
	private String idCard;// 用户身份证
	private String sex;// 性别
	private int age;// 年龄
	private String phone;// 电话
	private String department;// 部门
	private int status;// 状态
	private int role;// 角色

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", passwd="
				+ passwd + ", name=" + name + ", idCard=" + idCard + ", sex="
				+ sex + ", age=" + age + ", phone=" + phone + ", department="
				+ department + ", status=" + status + ", role=" + role + "]";
	}

}
