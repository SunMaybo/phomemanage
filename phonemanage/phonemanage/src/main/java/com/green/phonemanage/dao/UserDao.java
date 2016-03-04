package com.green.phonemanage.dao;

import java.util.List;

import com.green.phonemanage.model.SearchForm;
import com.green.phonemanage.model.User;

/**
 * @author maybo
 *
 */
public interface UserDao {
	public Integer login(User user);// 用户登录

	public void register(User user);// 用户注册

	public void rmove(int id);// 删除用户

	public void update(User user);// 修改用户

	public List<User> finds(SearchForm searchForm);// 查找用户

	public User findById(int id);// 查询用户通过id

	public Integer findByLoginName(String loginName);// 查询登录名是否存在
	
	public void freeze(int id);//冻结用户
	
	public void unfreeze(int id);//用户解冻
	
	public Integer totals();//查询总数
}
