package com.hantian.demo.junit;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hantian.demo.dao.IDepartmentDao;
import com.hantian.demo.dao.impl.DepartmentDaoImpl;
import com.hantian.demo.pojo.Department;

public class DepartmentDaoTest {
	private static ApplicationContext context;
	private static IDepartmentDao departmentDao;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		departmentDao = context.getBean(DepartmentDaoImpl.class);
	}

	@Test
	public void save() {
		Department department = new Department();
		department.setName("移动端组");
		department.setCreateTime(new Date());
		Department parent = new Department();
		parent.setId(1);
		department.setParent(parent);
		departmentDao.saveOrUpdate(department);
	}

	@Test
	public void update() {
		Department department = new Department();
		department.setName("移动组");
		department.setCreateTime(new Date());

		Department parent = new Department();
		parent.setId(3);
		department.setParent(parent);
		departmentDao.saveOrUpdate(department);
	}

	@Test
	public void findById() {
		departmentDao.findById(0);
	}

	@Test
	public void list() {
		System.out.println(departmentDao.list().toString());
	}

	@Test
	public void delete() {
		departmentDao.delete(2);
	}
}
