package com.green.phonemanage.junit.dao;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.green.phonemanage.dao.ClientDao;
import com.green.phonemanage.model.Client;
import com.green.phonemanage.model.SearchForm;

public class ClientTest {
	private static ApplicationContext context;
	private static ClientDao clientDao;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		clientDao = (ClientDao) context.getBean(ClientDao.class);// 获取指定对象

	}

	/*
	 * 添加客户信息
	 */
	@Test
	public void add() {
		Client client = new Client();
		client.setName("maybo");
		client.setPhone("15138666597");
		client.setAddress("����ʡ");
		client.setIdCard("411327199106140324");
		clientDao.add(client);
	}

	/*
	 * 通过id查询客户信息
	 */
	@Test
	public void findById() {
		Client client = clientDao.findById(3);
		System.out.println(client.toString());
	}

	/*
	 * 分页查询客户信息
	 *
	 */
	@Test
	public void finds() {
		SearchForm searchForm = new SearchForm();
		searchForm.setKey("maybo");
		searchForm.setPageIndex(0);
		searchForm.setPageSize(30);
		List<Client> clients = clientDao.finds(searchForm);
		System.out.println(clients.toString());
	}

	/*
	 * 修改指定客户信息
	 */
	@Test
	public void update() {
		Client client = new Client();
		client.setName("martyo");
		client.setId(1);
		client.setPhone("15138666597");
		client.setAddress("����ʡ֣����");
		client.setCode("20394022");
		client.setIdCard("411327199106140314");
		clientDao.update(client);
	}

	/*
	 * 通过id删除指定客户信息
	 */
	@Test
	public void rmove() {
		clientDao.rmove(3);
	}

}
