package com.green.phonemanage.junit.service;

import java.io.IOException;
import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.zxing.WriterException;
import com.green.phonemanage.model.CellPhone;
import com.green.phonemanage.model.Client;
import com.green.phonemanage.service.IPhoneService;

public class DataImportTest {
	private static ApplicationContext context;
	private static IPhoneService phoneService;
	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		phoneService = (IPhoneService) context.getBean("phoneService");// 获取用户对象

	}
	@Test
	public void importData() throws IOException, WriterException, Exception{
		int[] status=new int[]{1,2,3};
		int[] client=new int[]{1,2,3};
		Random random=new Random();
		String imei="20489";
		for(int i=1000;i<=9999;i++){
		Client client1=new Client();
		client1.setId(client[random.nextInt(3)]);
		Client client2=new Client();
		client2.setId(client[random.nextInt(3)]);
		CellPhone cellPhone=new CellPhone();
		cellPhone.setClient(client1);
		cellPhone.setReceiver(client2);
		cellPhone.setCreateDate("2015-12-07");
		cellPhone.setPhoneBrand("华为");
		cellPhone.setPhoneColor("白色");
		cellPhone.setPhoneModel("荣耀３Ｃ");
		cellPhone.setServiceLife("2018-01-12");
		cellPhone.setImei(imei+i);
		cellPhone.setStatus(status[random.nextInt(3)]);
		phoneService.add(cellPhone);
		}
	}
}
