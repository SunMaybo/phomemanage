package com.green.phonemanage.model;

/**
 * @author maybo
 *
 */
public class Client {
	private int id;
	private String code;// 客户编码
	private String address;// 地址
	private String name;// 客户名字
	private String idCard;// 客户身份证
	private String phone;// 客户电话
	private String province;// 省
	private String city;// 市
	private String area;// 区

	public void setArea(String area) {
		this.area = area;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getArea() {
		return area;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", code=" + code + ", address=" + address
				+ ", name=" + name + ", idCard=" + idCard + ", phone=" + phone
				+ "]";
	}

}
