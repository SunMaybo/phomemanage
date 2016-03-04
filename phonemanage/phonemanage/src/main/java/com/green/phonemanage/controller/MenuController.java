package com.green.phonemanage.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.green.phonemanage.model.MenuItem;

@RestController
public class MenuController {
	@RequestMapping(value = "/menu", method = RequestMethod.GET,produces="application/json")
	public List<MenuItem> menu(int role){
		List<MenuItem>items=new ArrayList<MenuItem>();
		if(role==1){
			MenuItem itemTop=new MenuItem();
			itemTop.setId("top");
			itemTop.setIconCls("icon-add");
			itemTop.setText("系统管理");
			items.add(itemTop);
		MenuItem itemPhone=new MenuItem();
		itemPhone.setId("phone");
		itemPhone.setText("手机管理");
		itemPhone.setIconCls("Phone");
		itemPhone.setUid("top");
		itemPhone.setIconPosition("top");
		itemPhone.setUrl("web/cellphone/index");
		items.add(itemPhone);
		MenuItem itemClient=new MenuItem();
		itemClient.setId("client");
		itemClient.setText("客户管理");
		itemClient.setIconCls("Client");
		itemClient.setUid("top");
		itemClient.setIconPosition("top");
		itemClient.setUrl("web/client/index");
		items.add(itemClient);
		MenuItem itemUser=new MenuItem();
		itemUser.setId("user");
		itemUser.setText("用户设置");
		itemUser.setUid("top");
		itemUser.setIconPosition("top");
		itemUser.setIconCls("User");
		itemUser.setUrl("web/user/edit");
		items.add(itemUser);
		}
		if(role==2){
				MenuItem itemTop=new MenuItem();
				itemTop.setId("top");
				itemTop.setIconCls("icon-add");
				itemTop.setText("系统管理");
				items.add(itemTop);
			MenuItem itemPhone=new MenuItem();
			itemPhone.setId("phone");
			itemPhone.setText("手机管理");
			itemPhone.setIconCls("Phone");
			itemPhone.setUid("top");
			itemPhone.setIconPosition("top");
			itemPhone.setUrl("web/cellphone/index");
			items.add(itemPhone);
			MenuItem itemClient=new MenuItem();
			itemClient.setId("client");
			itemClient.setText("客户管理");
			itemClient.setIconCls("Client");
			itemClient.setUid("top");
			itemClient.setIconPosition("top");
			itemClient.setUrl("web/client/index");
			items.add(itemClient);
			MenuItem itemUser=new MenuItem();
			itemUser.setId("user");
			itemUser.setText("用户管理");
			itemUser.setUid("top");
			itemUser.setIconPosition("top");
			itemUser.setIconCls("User");
			itemUser.setUrl("web/user/index");
			items.add(itemUser);
			MenuItem itemＰwd=new MenuItem();
			itemＰwd.setId("pwd");
			itemＰwd.setText("修改密码");
			itemＰwd.setUid("top");
			itemＰwd.setIconPosition("top");
			itemＰwd.setIconCls("Pwd");
			itemＰwd.setUrl("web/user/edit/pwd");
			items.add(itemＰwd);
		}
		MenuItem itemTop2=new MenuItem();
		itemTop2.setId("top2");
		itemTop2.setIconCls("icon-add");
		itemTop2.setText("分析");
		items.add(itemTop2);
		MenuItem itemStatus=new MenuItem();
		itemStatus.setId("status");
		itemStatus.setText("状态");
		itemStatus.setUid("top2");
		itemStatus.setIconPosition("left");
		itemStatus.setIconCls("status");
		itemStatus.setUrl("web/bar/status");
		items.add(itemStatus);
		MenuItem itemBrand=new MenuItem();
		itemBrand.setId("brand");
		itemBrand.setText("品牌");
		itemBrand.setUid("top2");
		itemBrand.setIconPosition("left");
		itemBrand.setIconCls("brand");
		itemBrand.setUrl("web/bar/brand");
		items.add(itemBrand);
		MenuItem itemCity=new MenuItem();
		itemCity.setId("city");
		itemCity.setText("地址");
		itemCity.setUid("top2");
		itemCity.setIconPosition("left");
		itemCity.setIconCls("city");
		itemCity.setUrl("web/bar/address");
		items.add(itemCity);
		return items;
	}
}
