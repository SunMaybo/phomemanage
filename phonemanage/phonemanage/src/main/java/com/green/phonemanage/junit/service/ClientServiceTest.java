package com.green.phonemanage.junit.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.green.phonemanage.model.Client;
import com.green.phonemanage.service.IClientService;

public class ClientServiceTest {
	private static ApplicationContext context;
	private static IClientService clientService;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		clientService = (IClientService) context.getBean("clientService");// 获取用户对象

	}

	@Test
	public void add() {
		Client client = new Client();
		client.setName("maybo");
		client.setPhone("15138666597");
		client.setAddress("����ʡ");
		client.setIdCard("411327199106140324");
		try {
			clientService.add(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
