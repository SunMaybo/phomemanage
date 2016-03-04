package com.green.phonemanage.model;

/**
 * @author maybo
 *
 */
public class UserMsg {
	private int role;// 鐢ㄦ埛瑙掕壊
	private String msg;// 娉ㄥ唽淇℃伅
	private int status;// 娉ㄥ唽鐘舵��
	private int userId;//用户的标识

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserMsg [role=" + role + ", msg=" + msg + ", status=" + status + ", userId=" + userId + "]";
	}

	
}
