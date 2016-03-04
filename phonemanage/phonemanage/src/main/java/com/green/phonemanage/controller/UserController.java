package com.green.phonemanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.phonemanage.dao.UserDao;
import com.green.phonemanage.model.Msg;
import com.green.phonemanage.model.SearchForm;
import com.green.phonemanage.model.User;
import com.green.phonemanage.model.UserMsg;
import com.green.phonemanage.service.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * �û���¼
	 * 
	 * @param:��¼��
	 * 
	 * @param:����
	 * 
	 * @param:��ɫ��1.�ͻ���2������Ա
	 * 
	 * @return:��¼��Ϣ
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public UserMsg login(@RequestParam String loginName, @RequestParam String passwd,
			@RequestParam int role) {
		User user = new User();
		user.setLoginName(loginName);
		user.setPasswd(passwd);
		user.setRole(role);
		return userService.login(user);
	}

	/*
	 * �û�ע��
	 * 
	 * @param:�û���Ϣ
	 * 
	 * @return:�û�ע����Ϣ
	 */
	@RequestMapping(value = "user/register", method = RequestMethod.POST,produces="application/json",consumes="application/json")
	public UserMsg register(@RequestBody User user) {
		user.setStatus(1);
		return userService.register(user);
	}

	/*
	 * 查询登录名是否存在
	 * 
	 * @param:登录名
	 * 
	 * @return:状态
	 */
	@RequestMapping(value = "user/ne", method = RequestMethod.GET)
	public UserMsg nameExist(@RequestParam("loginName") String loginName) {
		UserMsg um = new UserMsg();
		um.setMsg("登录名不存在");
		um.setStatus(1);
		Integer id = userDao.findByLoginName(loginName);
		if (id != null) {
			um.setStatus(0);
			um.setMsg("登录名已经存在");
		}
		return um;
	}

	/*
	 * ͨ��id��ȡ�û���Ϣ
	 * 
	 * @param:�û�id
	 * 
	 * @return:�û���Ϣ
	 */
	@RequestMapping(value = "user/find", method = RequestMethod.GET)
	public User findUser(@RequestParam("id") int id) {
		return userDao.findById(id);
	}

	/*
	 * �û���Ϣ��ҳ��ѯ
	 * 
	 * @param:��ҳ��Ϣ
	 * 
	 * @return:�û���Ϣ�б�
	 */
	@RequestMapping(value = "user/finds", method = RequestMethod.POST)
	public Map<String, Object> finds(SearchForm searchForm) {
		searchForm.setPageIndex(searchForm.getPageIndex() * searchForm.getPageSize());
		List<User> users = userDao.finds(searchForm);
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("data", users);
		datas.put("total", userDao.totals()==null?0:userDao.totals());
		return datas;
	}

	/*
	 * ɾ��ָ�����û�
	 * 
	 * @param:�û�id
	 * 
	 * @return:��Ϣ
	 */
	@RequestMapping(value = "user/rm", method = RequestMethod.GET)
	public Msg remove(@RequestParam("id") int id) {
		Msg rmMsg = new Msg();
		rmMsg.setId(id);
		rmMsg.setMsg("ɾ���ɹ�");
		rmMsg.setState(1);
		try {
			userDao.rmove(id);
		} catch (Exception e) {
			rmMsg.setState(0);
			rmMsg.setMsg("ɾ��ʧ��");
		}
		return rmMsg;
	}

	/*
	 * �޸��û���Ϣ
	 * 
	 * @param:�û�id
	 * 
	 * @return:�û�״̬
	 */
	@RequestMapping(value = "user/update", method = RequestMethod.POST)
	public Msg update(User user) {
		Msg rmMsg = new Msg();
		rmMsg.setId(user.getId());
		rmMsg.setMsg("�޸ĳɹ�");
		rmMsg.setState(1);
		try {
			userDao.update(user);
		} catch (Exception e) {
			rmMsg.setState(0);
			rmMsg.setMsg("�޸�ʧ��");
		}
		return rmMsg;
	}

	/*
	 * �û�����
	 * 
	 * @param:�û�id
	 * 
	 * @return:���ز���״̬
	 */
	@RequestMapping(value = "user/freeze", method = RequestMethod.GET)
	public Msg freeze(@RequestParam("id") int id) {
		Msg msg = new Msg();
		msg.setId(id);
		msg.setState(1);
		msg.setMsg("成功");
		try {
			userDao.freeze(id);
		} catch (Exception e) {
			msg.setState(0);
			msg.setMsg("失败");
		}

		return msg;
	}

	/*
	 * �û��ⶳ
	 * 
	 * @param:�û�id
	 * 
	 * @return:���ز���״̬
	 */
	@RequestMapping(value = "user/unfreeze", method = RequestMethod.GET)
	public Msg unfreeze(@RequestParam("id") int id) {
		Msg msg = new Msg();
		msg.setId(id);
		msg.setState(1);
		msg.setMsg("成功");
		try {
			userDao.unfreeze(id);
		} catch (Exception e) {
			msg.setState(0);
			msg.setMsg("失败");
		}

		return msg;
	}
}
