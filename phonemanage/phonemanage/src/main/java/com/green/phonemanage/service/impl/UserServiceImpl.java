package com.green.phonemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.green.phonemanage.dao.UserDao;
import com.green.phonemanage.model.User;
import com.green.phonemanage.model.UserMsg;
import com.green.phonemanage.service.IUserService;

/**
 * @author maybo
 */
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * 注册用户
	 * 
	 * @param:用户信息
	 * 
	 * @return:注册消息
	 */
	public UserMsg register(User user)  {
		UserMsg userMsg = new UserMsg();
		userMsg.setRole(user.getRole());// 用户角色，1，普通用户，2，管理员
		userMsg.setStatus(1);// 1:登录状态，1，成功,其他，失败
		if(user.getId()>0){
			userDao.update(user);
		}else{
			userDao.register(user);
		}
			userMsg.setMsg("注册成功");
		return userMsg;
	}

	/*
	 * 登录用户
	 * 
	 * @patam:用户信息包含，登录名，密码，角色
	 * 
	 * @return:用户登录状态
	 */
	public UserMsg login(User user) {

		UserMsg userMsg = new UserMsg();
		userMsg.setRole(user.getRole());
		userMsg.setStatus(1);
		Integer id=null;
		id = userDao.login(user);
		if (id != null) {
			userMsg.setUserId(id);
			userMsg.setStatus(1);
			userMsg.setMsg("登录成功");
		} else {
			userMsg.setStatus(0);
			userMsg.setMsg("登录失败");
		}
		return userMsg;
	}

	/*
	 * 通过登录名查询用户是否存在
	 * 
	 */
	public UserMsg findUserExist(String loginName) {
		UserMsg userMsg = new UserMsg();
		userMsg.setStatus(1);
		userMsg.setMsg("用户存在");
		Integer id=null;
		id = userDao.findByLoginName(loginName);
		if (id == null) {
			userMsg.setStatus(0);
			userMsg.setMsg("用户不存在");
		}
		return userMsg;
	}

}
