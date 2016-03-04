package com.hantian.demo.junit;

import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hantian.demo.dao.IUserDao;
import com.hantian.demo.dao.impl.UserDaoImpl;
import com.hantian.demo.pojo.Department;
import com.hantian.demo.pojo.SearchForm;
import com.hantian.demo.pojo.User;

public class UserDaoTest {
	private static ApplicationContext context;
	private static IUserDao userDao;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		userDao = context.getBean(UserDaoImpl.class);
	}

	@Test
	public void save() {
		// 添加测试
		User user = new User();
		user.setCreateTime(new Date());
		Department department = new Department();
		department.setId(1);
		user.setDepartment(department);
		user.setEmail("930147677@qq.com");
		user.setName("马运宝");
		user.setPhone("15128666597");
		user.setPosition("研发人员");
		user.setSex("男");
		user.setStatus(1);
		user.setWorkNumber(Long.valueOf("20160301028"));
		userDao.saveOrUpdate(user);

	}

	@Test
	public void update() {
		// 修改测试
		User user = new User();
		user.setCreateTime(new Date());
		Department department = new Department();
		department.setId(1);
		user.setId(2);
		user.setDepartment(department);
		user.setEmail("SunMaybo@hotmail.com");
		user.setName("SunMaybo");
		user.setPhone("1512666597");
		user.setPosition("研发人员");
		user.setSex("男");
		user.setStatus(1);
		user.setWorkNumber(Long.valueOf("20160301028"));
		userDao.saveOrUpdate(user);
	}

	@Test
	public void findById() {
		User user = userDao.findById(2);
		System.out.println(user.toString());
	}

	@Test
	public void list() {
		SearchForm searchForm = new SearchForm();
		searchForm.setPage(1);
		searchForm.setPageSize(30);
		Map<String, Object> result = userDao.list(searchForm);
		System.out.println(result.toString());
	}

	@Test
	public void listByKey() {
		SearchForm searchForm = new SearchForm();
		searchForm.setPage(1);
		searchForm.setPageSize(30);
		searchForm.setKey("may");
		Map<String, Object> result = userDao.list(searchForm);
		System.out.println(result.toString());
	}

	@Test
	public void delete() {
		userDao.delete(2);
	}
}
