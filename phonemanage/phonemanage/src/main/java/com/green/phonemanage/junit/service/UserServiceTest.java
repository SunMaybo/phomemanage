package com.green.phonemanage.junit.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.green.phonemanage.model.User;
import com.green.phonemanage.service.IUserService;

public class UserServiceTest {
	private static ApplicationContext context;
	private static IUserService userService;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		userService = (IUserService) context.getBean("userService");// 获取用户对象

	}

	@Test
	public void register() {
		User user = new User();
		user.setAge(25);
		user.setDepartment("�з���");
		user.setIdCard("411327199106140314");
		user.setLoginName("maybo1111");
		user.setName("���˱�");
		user.setPasswd("maybo1234");
		user.setPhone("15138666597");
		user.setRole(1);
		user.setSex("��");
		user.setStatus(0);
		try {
			System.out.println(userService.register(user).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void login() {
		User user = new User();
		user.setLoginName("maybo1112");
		user.setPasswd("maybo1234");
		try {
			System.out.println(userService.login(user).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void findUserExist(){
		try {
			System.out.println(userService.findUserExist("maybo1111").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
