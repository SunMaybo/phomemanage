package com.green.phonemanage.model;

public class Msg {
private int id;
private String msg;
private int state;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
@Override
public String toString() {
	return "RmMsg [id=" + id + ", msg=" + msg + ", state=" + state + "]";
}

}
