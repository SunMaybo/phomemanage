package com.green.phonemanage.service;

import java.io.IOException;
import java.util.List;

import com.google.zxing.WriterException;
import com.green.phonemanage.model.CellPhone;
import com.green.phonemanage.model.SearchTotal;

/**
 * @author maybo
 *
 */
public interface IPhoneService {
	public void add(CellPhone cellPhone) throws IOException, WriterException, Exception;// 添加手机信息
	
	public List<SearchTotal>findTotal(int type);//查询总数通过类别
}
