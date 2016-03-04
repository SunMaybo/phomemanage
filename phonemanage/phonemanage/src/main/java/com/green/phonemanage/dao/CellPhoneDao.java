package com.green.phonemanage.dao;


import java.sql.Blob;
import java.util.List;

import com.green.phonemanage.model.CellPhone;
import com.green.phonemanage.model.SearchForm;

/**
 * @author maybo
 *
 */
public interface CellPhoneDao {
	public void add(CellPhone cellPhone);// 添加手机

	public void rmove(int id);// 删除手机

	public void update(CellPhone cellPhone);// 修改手机

	public List<CellPhone> finds(SearchForm searchForm);// 查询手机

	public CellPhone findById(int id);// 查询手机通过id

	public Integer findByIMEI(String IMEI);// 通过手机串号查询手机是否已经存在
	
	public CellPhone findQr(int id);// 查询手机二维码通过id
	
	public Integer findByClient(int id);//查询通过用户id
	
	public Integer findTotalByStatus(int status);//查询总数通过状态

	public Integer findTotalByBrand(String brand);//查询总数通过品牌
	
	public Integer findTotalByAddress(String address);//查询总数通过地址
	
	public List<String> findBrands();//查询品牌
	
	public List<Integer> findStatus();//查询所状态
	
	public List<String> findCitys();//查询所有城市
	
	public Integer totals();//查询总数
	
}
