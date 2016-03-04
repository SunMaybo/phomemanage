package com.green.phonemanage.junit.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.green.phonemanage.dao.UserDao;
import com.green.phonemanage.model.SearchForm;
import com.green.phonemanage.model.User;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class UserTest {
	private static ApplicationContext context;
	private static UserDao userDao;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		userDao = (UserDao) context.getBean(UserDao.class);// 创建指定对象

	}

	/*
	 * 用户注册
	 */
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
		userDao.register(user);
	}

	/*
	 * 用户登录
	 */
	@Test
	public void login() {
		User user = new User();
		user.setLoginName("maybo1111");
		user.setPasswd("maybo1234");
		int userId = userDao.login(user);
		System.out.println(userId);
	}

	/*
	 * ͨ通过id查询用户
	 */
	@Test
	public void findById() {
		User user = userDao.findById(6);
		System.out.println(user.toString());
	}

	/*
	 * 通过分页查询用户
	 *
	 */
	@Test
	public void finds() {
		SearchForm searchForm = new SearchForm();
		searchForm.setKey("maybo");
		searchForm.setPageIndex(0);
		searchForm.setPageSize(30);
		List<User> users = userDao.finds(searchForm);
		System.out.println(users.toString());
	}

	/*
	 * 修改用户通过id
	 */
	@Test
	public void update() {
		User user = new User();
		user.setId(6);
		user.setAge(25);
		user.setDepartment("�з���");
		user.setIdCard("411327199106140314");
		user.setLoginName("maybo1111");
		user.setName("���˱�");
		user.setPasswd("maybo1234");
		user.setPhone("15138666596");
		user.setRole(1);
		user.setSex("��");
		user.setStatus(0);
		userDao.update(user);
	}

	/*
	 * 通过id删除用户
	 */
	@Test
	public void rmove() {
		userDao.rmove(6);
	}
}
