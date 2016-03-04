package com.green.phonemanage.junit.dao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.green.phonemanage.dao.CellPhoneDao;
import com.green.phonemanage.model.CellPhone;
import com.green.phonemanage.model.Client;
import com.green.phonemanage.model.SearchForm;

public class CellPhoneTest {

	private static ApplicationContext context;
	private static CellPhoneDao cellPhoneDao;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		cellPhoneDao = (CellPhoneDao) context.getBean(CellPhoneDao.class);// 获取对象

	}

	/*
	 * 添加手机信息测试
	 */
	@Test
	public void add() {
		CellPhone cellPhone = new CellPhone();
		Client client = new Client();
		client.setId(5);
		cellPhone.setClient(client);
		cellPhone.setCreateDate("2012-11-01");
		cellPhone.setImei("2356433");
		cellPhone.setPhoneBrand("��Ϊ");
		cellPhone.setPhoneColor("��ɫ");
		cellPhone.setPhoneModel("��ҫ3C");

		cellPhone.setQrCode("����һ����ά���������".getBytes());
		cellPhone.setReceiver(client);
		cellPhoneDao.add(cellPhone);
	}

	/*
	 * ͨ通过id获取手机信息
	 */
	@Test
	public void findById() {
		CellPhone cellPhone = cellPhoneDao.findById(1);
		System.out.println(cellPhone.toString());
	}

	/*
	 * 查询手机信息通过分页
	 *
	 */
	@Test
	public void finds() {
		SearchForm searchForm = new SearchForm();
		searchForm.setKey("��Ϊ");
		searchForm.setPageIndex(0);
		searchForm.setPageSize(30);
		List<CellPhone> cellPhones = cellPhoneDao.finds(searchForm);
		System.out.println(cellPhones.toString());
	}

	/*
	 * 修改手机信息信息
	 */
	@Test
	public void update() {
		CellPhone cellPhone = new CellPhone();
		Client client = new Client();
		client.setId(5);
		
		cellPhone.setImei("2356433");
		cellPhone.setPhoneBrand("��Ϊ");
		cellPhone.setPhoneColor("��ɫ");
		cellPhone.setPhoneModel("��ҫ3C");

		cellPhone.setQrCode("����һ����ά���������".getBytes());
		cellPhone.setId(1);
		cellPhone.setClient(client);
		cellPhone.setReceiver(client);
		cellPhoneDao.update(cellPhone);
	}

	/*
	 * 删除手机信息通过id
	 */
	@Test
	public void rmove() {
		cellPhoneDao.rmove(3);
	}
}
