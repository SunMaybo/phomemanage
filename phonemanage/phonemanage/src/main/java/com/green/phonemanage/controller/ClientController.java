package com.green.phonemanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.green.phonemanage.dao.CellPhoneDao;
import com.green.phonemanage.dao.ClientDao;
import com.green.phonemanage.model.Client;
import com.green.phonemanage.model.Msg;
import com.green.phonemanage.model.SearchForm;
import com.green.phonemanage.service.IClientService;

;

@RestController
public class ClientController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@Autowired
	private CellPhoneDao cellPhoneDao;

	public void setCellPhoneDao(CellPhoneDao cellPhoneDao) {
		this.cellPhoneDao = cellPhoneDao;
	}

	@Autowired
	private ClientDao clientDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@RequestMapping(value = "/tst", method = RequestMethod.GET)
	public void tst(@RequestParam("id") int id) {
		System.out.println("This is a test.");
	}

	/*
	 * 通鏌ユ壘瀹㈡埛
	 * 
	 * @param:瀹㈡埛id
	 * 
	 * @return:瀹㈡埛淇℃伅
	 */
	@RequestMapping(value = "/client/find", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public Client findUser(@RequestParam("id") int id) {
		return clientDao.findById(id);
	}

	/*
	 * 鍒嗛〉鑾峰彇瀹㈡埛淇℃伅
	 * 
	 * @param:鍒嗛〉淇℃伅
	 * 
	 * @return:鍒嗛〉鎵�鏈夊鎴蜂俊鎭�
	 */
	@RequestMapping(value = "client/finds", method = RequestMethod.POST)
	public Map<String, Object> finds(SearchForm searchForm) {
		searchForm.setPageIndex(searchForm.getPageIndex()
				* searchForm.getPageSize());
		List<Client> r = clientDao.finds(searchForm);
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("data", r);
		datas.put("total", clientDao.totals()==null?0:clientDao.totals());
		return datas;
	}

	/*
	 * 绉婚櫎瀹㈡埛
	 * 
	 * @param:瀹㈡埛id
	 * 
	 * @return:鐘舵��
	 */
	@RequestMapping(value = "client/rm", method = RequestMethod.GET)
	public Msg remove(@RequestParam("id") int id) {
		Msg rmMsg = new Msg();
		rmMsg.setId(id);
		rmMsg.setMsg("刪除成功");
		rmMsg.setState(1);
		try {
			Integer phoneId=null;
			phoneId=cellPhoneDao.findByClient(id);
			if(null==phoneId){
			clientDao.rmove(id);
			}else{
				rmMsg.setState(0);
				rmMsg.setMsg("手机被使用的用户，无法删除。");
			}
		} catch (Exception e) {
			rmMsg.setState(0);
			rmMsg.setMsg("手机被使用的用户，无法删除。");
		}
		return rmMsg;
	}

	/*
	 * 淇敼瀹㈡埛淇℃伅
	 * 
	 * @param:瀹㈡埛淇℃伅
	 * 
	 * @return:鐘舵�佔刺�
	 * 
	 * @RequestMapping(value = "client/update", method = RequestMethod.POST)
	 * public Msg update(@ModelAttribute("client") Client client) {
	 * 
	 * Msg rmMsg = new Msg(); rmMsg.setId(client.getId());
	 * rmMsg.setMsg("绉婚櫎鎴愬姛"); rmMsg.setState(1); try {
	 * clientDao.update(client); } catch (Exception e) { rmMsg.setState(0);
	 * rmMsg.setMsg("绉婚櫎澶辫触"); } return rmMsg; }
	 */

	/*
	 * 娣诲姞瀹㈡埛淇℃伅
	 * 
	 * @param:瀹㈡埛淇℃伅
	 * 
	 * @return:鐘舵�佔刺�
	 */
	@RequestMapping(value = "client/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Msg add(@RequestBody Client client) {
		logger.debug(client.toString());
		Msg rmMsg = new Msg();
		rmMsg.setId(client.getId());
		rmMsg.setMsg("修改成功");
		rmMsg.setState(1);
		try {
			clientService.add(client);
		} catch (Exception e) {
			rmMsg.setState(0);
			rmMsg.setMsg("客戶已經存在");
		}
		return rmMsg;
	}
}
