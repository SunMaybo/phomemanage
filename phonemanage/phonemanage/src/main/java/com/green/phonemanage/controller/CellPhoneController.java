package com.green.phonemanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.phonemanage.dao.CellPhoneDao;
import com.green.phonemanage.model.CellPhone;
import com.green.phonemanage.model.Msg;
import com.green.phonemanage.model.SearchForm;
import com.green.phonemanage.service.IPhoneService;

@RestController
public class CellPhoneController {
	@Autowired
	private IPhoneService phoneService;

	public void setPhoneService(IPhoneService phoneService) {
		this.phoneService = phoneService;
	}

	@Autowired
	private CellPhoneDao cellPhoneDao;

	public void setCellPhoneDao(CellPhoneDao cellPhoneDao) {
		this.cellPhoneDao = cellPhoneDao;
	}

	/*
	 * ͨ查找手机
	 * 
	 * @param:手机id
	 * 
	 * @return:手机信息
	 */
	@RequestMapping(value = "cellphone/find", method = RequestMethod.GET)
	public CellPhone findUser(@RequestParam("id") int id) {
		return cellPhoneDao.findById(id);
	}

	/*
	 * 分页获取手机信息
	 * 
	 * @param:分页信息
	 * 
	 * @return:分页所有手机信息
	 */
	@RequestMapping(value = "cellphone/finds", method = RequestMethod.POST)
	public Map<String, Object> finds(SearchForm searchForm) {
		searchForm.setPageIndex(searchForm.getPageIndex() * searchForm.getPageSize());
		List<CellPhone>r= cellPhoneDao.finds(searchForm);
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("data", r);
		datas.put("total", cellPhoneDao.totals()==null?0:cellPhoneDao.totals());
		return  datas;
	}

	/*
	 * 移除手机
	 * 
	 * @param:手机id
	 * 
	 * @return:状态
	 */
	@RequestMapping(value = "cellphone/rm", method = RequestMethod.GET)
	public Msg remove(@RequestParam("id") int id) {
		Msg rmMsg = new Msg();
		rmMsg.setId(id);
		rmMsg.setMsg("删除成功");
		rmMsg.setState(1);
		try {
			cellPhoneDao.rmove(id);
		} catch (Exception e) {
			rmMsg.setState(0);
			rmMsg.setMsg("删除失败");
		}
		return rmMsg;
	}

	/*
	 * 修改手機信息
	 * 
	 * @param:手機信息
	 * 
	 * @return:状态״̬
	 */
	@RequestMapping(value = "cellphone/update", method = RequestMethod.POST,consumes="application/json")
	public Msg update(@RequestBody CellPhone cellphone) {
		Msg rmMsg = new Msg();
		rmMsg.setId(cellphone.getId());
		rmMsg.setMsg("移除成功");
		rmMsg.setState(1);
		try {
			phoneService.add(cellphone);
		} catch (Exception e) {
			rmMsg.setState(0);
			rmMsg.setMsg("移除失败");
		}
		return rmMsg;
	}

	/*
	 * 添加手机信息
	 * 
	 * @param:手机信息
	 * 
	 * @return:状态״̬
	 */
	@RequestMapping(value = "cellphone/add", method = RequestMethod.POST,consumes="application/json")
	public Msg add(@RequestBody  CellPhone cellphone) {
		cellphone.setStatus(1);
		Msg rmMsg = new Msg();
		rmMsg.setId(cellphone.getId());
		rmMsg.setMsg("添加成功");
		rmMsg.setState(1);
		try {
			phoneService.add(cellphone);
		} catch (Exception e) {
			rmMsg.setState(0);
			rmMsg.setMsg("添加失败");
		}
		return rmMsg;
	}
}
