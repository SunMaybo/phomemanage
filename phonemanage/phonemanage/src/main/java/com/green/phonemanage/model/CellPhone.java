package com.green.phonemanage.model;

import java.util.Arrays;
import java.util.Date;

/**
 * @author maybo
 *
 */
public class CellPhone {
	private int id;
	private String phoneBrand;// 手机品牌
	private String phoneModel;// 手机型号
	private String phoneColor;// 手机颜色
	private Client client;// 客户
	private Client receiver;// 签收人
	private String createDate;// 创建时间
	private String serviceLife;// 寿命
	private byte[] qrCode;// 二维码
	private int status;// 状态
	private String imei;// 手机串号

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneBrand() {
		return phoneBrand;
	}

	public void setPhoneBrand(String phoneBrand) {
		this.phoneBrand = phoneBrand;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getPhoneColor() {
		return phoneColor;
	}

	public void setPhoneColor(String phoneColor) {
		this.phoneColor = phoneColor;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getReceiver() {
		return receiver;
	}

	public void setReceiver(Client receiver) {
		this.receiver = receiver;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setServiceLife(String serviceLife) {
		this.serviceLife = serviceLife;
	}

	public String getServiceLife() {
		return serviceLife;
	}

	public byte[] getQrCode() {
		return qrCode;
	}

	public void setQrCode(byte[] qrCode) {
		this.qrCode = qrCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImei() {
		return imei;
	}

	@Override
	public String toString() {
		return "CellPhone [id=" + id + ", phoneBrand=" + phoneBrand
				+ ", phoneModel=" + phoneModel + ", phoneColor=" + phoneColor
				+ ", client=" + client + ", receiver=" + receiver
				+ ", createDate=" + createDate + ", serviceLife=" + serviceLife
				+ ", qrCode=" + Arrays.toString(qrCode) + ", status=" + status
				+ ", IMEI=" + imei + "]";
	}

}
