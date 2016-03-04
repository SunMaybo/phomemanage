package com.green.phonemanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.green.phonemanage.dao.CellPhoneDao;
import com.green.phonemanage.dao.ClientDao;
import com.green.phonemanage.model.CellPhone;
import com.green.phonemanage.model.Client;
import com.green.phonemanage.model.SearchTotal;
import com.green.phonemanage.service.IPhoneService;
import com.green.util.QrCodeGenerator;

/**
 * @author maybo
 *
 */
public class PhoneServiceImpl implements IPhoneService {
	@Autowired
	private CellPhoneDao cellPhoneDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Autowired
	private ClientDao clientDao;

	public void setCellPhoneDao(CellPhoneDao cellPhoneDao) {
		this.cellPhoneDao = cellPhoneDao;
	}

	/*
	 * 添加手机信息
	 * 
	 * @param:手机信息
	 */
	public void add(CellPhone cellPhone) throws Exception {
		Client client = clientDao.findById(cellPhone.getClient().getId());
		Integer id = null;
		if (client == null) {
			throw new NullPointerException("客户不可以为空");
		}
		id = cellPhoneDao.findByIMEI(cellPhone.getImei());
		if (null != id && cellPhone.getId() <= 0) {
			throw new Exception("手机已经存在");
		} else {
			cellPhone.setQrCode(QrCodeGenerator.build("客户编号:"
					+ client.getCode() + "手机串号:" + cellPhone.getImei()));
			if (cellPhone.getId() > 0) {
				cellPhoneDao.update(cellPhone);
			} else
				cellPhoneDao.add(cellPhone);
		}
	}

	@Override
	public List<SearchTotal> findTotal(int type) {
		List<SearchTotal> totals = new ArrayList<SearchTotal>();
		switch (type) {
		case 1:// 查询通过品牌
				// 获取所有品牌
			List<String> brands = cellPhoneDao.findBrands();
			for (String s : brands) {
				SearchTotal searchTotal = new SearchTotal();
				searchTotal.setBrand(s);
				Integer total = cellPhoneDao.findTotalByBrand(s);
				searchTotal.setTotal(total);
				totals.add(searchTotal);
			}
			break;
		case 2:// 查询通过状态
				// 查询所有状态
			List<Integer> status = cellPhoneDao.findStatus();
			for (Integer s : status) {
				SearchTotal searchTotal = new SearchTotal();
				searchTotal.setStatus(s);
				Integer total = cellPhoneDao.findTotalByStatus(s);
				searchTotal.setTotal(total);
				totals.add(searchTotal);
			}
			break;
		case 3:// 查询通过地址
				// 获取所有市级查询
			List<String> citys = cellPhoneDao.findCitys();
			for (String s : citys) {
				SearchTotal searchTotal = new SearchTotal();
				searchTotal.setCity(s);
				Integer total = cellPhoneDao.findTotalByAddress(s);
				searchTotal.setTotal(total);
				totals.add(searchTotal);
		
		}
			break;
	}
		return totals;
	}
}
