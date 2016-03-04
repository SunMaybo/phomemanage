package com.hantian.demo.pojo;

import java.util.Date;


/**
  * @ClassName: baseObject
  * @Description: TODO
  * @author maybo
  * @date 2016年3月2日 上午11:21:37
  *
  */
public class BaseObject {
	private Integer id;// 主鍵自增
	private Date createTime;//創建時間
	private int version;// 版本號

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "baseObject [id=" + id + ", createTime=" + createTime
				+ ", version=" + version + "]";
	}

}
