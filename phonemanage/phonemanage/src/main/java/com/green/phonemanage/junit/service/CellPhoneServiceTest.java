package com.green.phonemanage.junit.service;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.zxing.WriterException;
import com.green.phonemanage.model.CellPhone;
import com.green.phonemanage.model.Client;
import com.green.phonemanage.service.IPhoneService;

public class CellPhoneServiceTest {
	private static ApplicationContext context;
	private static IPhoneService phoneService;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		phoneService = (IPhoneService) context.getBean("phoneService");// 获取用户对象

	}
@Test public void findTotal(){
	System.out.println(phoneService.findTotal(1).toString());
	System.out.println(phoneService.findTotal(2).toString());
	System.out.println(phoneService.findTotal(3).toString());
}
	@Test
	public void add() {
		CellPhone cellPhone = new CellPhone();
		Client client = new Client();
		client.setId(1);
		client.setCode("efawetgwewey34636rherheryh");
		cellPhone.setClient(client);
		cellPhone.setCreateDate("2015-11-23");
		cellPhone.setImei("23578423");
		cellPhone.setPhoneBrand("��Ϊ");
		cellPhone.setPhoneColor("��ɫ");
		cellPhone.setPhoneModel("��ҫ3C");
		cellPhone.setReceiver(client);
		try {
			phoneService.add(cellPhone);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
