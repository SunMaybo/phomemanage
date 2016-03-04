package com.hantian.demo.dao;

import java.util.Map;

import com.hantian.demo.pojo.SearchForm;
import com.hantian.demo.pojo.User;

public interface IUserDao {

	/**
	 * 
	 * @Title: saveOrUpdate
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param user 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public abstract void saveOrUpdate(User user);

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public abstract void delete(int id);

	public abstract User findById(int id);

	public abstract Map<String, Object> list(SearchForm searchForm);

}