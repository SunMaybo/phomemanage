package com.green.phonemanage.model;

public class SearchTotal {
	private int status;
	private String city;
	private String brand;
	private int total;

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBrand() {
		return brand;
	}

	public String getCity() {
		return city;
	}

	public int getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "SearchTotal [status=" + status + ", city=" + city + ", brand="
				+ brand + ", total=" + total + "]";
	}



}
