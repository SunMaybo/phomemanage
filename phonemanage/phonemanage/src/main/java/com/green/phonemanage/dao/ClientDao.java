package com.green.phonemanage.dao;

import java.util.List;

import com.green.phonemanage.model.Client;
import com.green.phonemanage.model.SearchForm;

/**
 * @author maybo
 *
 */
public interface ClientDao {
	public void add(Client client);// 添加客户

	public void rmove(int id);// 删除客户

	public void update(Client client);// 修改客户

	public List<Client> finds(SearchForm searchForm);// 查询客户

	public Client findById(int id);// 查询客户通过id
	
	public Integer findByIdCard(String idCard);//通过身份证查询客户是否存在
	
	public Integer totals();//查询总数
}
