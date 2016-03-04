package com.green.phonemanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.green.phonemanage.model.SearchTotal;
import com.green.phonemanage.service.IPhoneService;

@RestController
public class TotalController {
	@Autowired
	private IPhoneService phoneService;
	public void setPhoneService(IPhoneService phoneService) {
		this.phoneService = phoneService;
	}
	@RequestMapping(value = "/total/data", method = RequestMethod.GET)
	public List<SearchTotal> datas(int type) {
		return phoneService.findTotal(type);
	}
}
