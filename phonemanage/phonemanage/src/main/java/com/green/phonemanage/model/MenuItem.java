package com.green.phonemanage.model;

public class MenuItem {
private String id;
private String uid;
private String pid;
private String url;
private String iconCls;
private String text;
private String iconPosition;
public void setIconPosition(String iconPosition) {
	this.iconPosition = iconPosition;
}
public String getIconPosition() {
	return iconPosition;
}
public void setText(String text) {
	this.text = text;
}
public String getText() {
	return text;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public void setIconCls(String iconCls) {
	this.iconCls = iconCls;
}
public String getIconCls() {
	return iconCls;
}
@Override
public String toString() {
	return "MenuItem [id=" + id + ", uid=" + uid + ", pid=" + pid + ", url="
			+ url + ", icon=" + iconCls + "]";
}

}
