package com.green.phonemanage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.phonemanage.dao.CellPhoneDao;

@Controller
public class TestController {
	@Autowired
	private CellPhoneDao cellPhoneDao;
	public void setCellPhoneDao(CellPhoneDao cellPhoneDao) {
		this.cellPhoneDao = cellPhoneDao;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "index";
	}
/*	@RequestMapping(value = "/image/get")
	public void getImage(HttpServletRequest request,HttpServletResponse response) {
	    response.setContentType("image/gif");
	    try {
	        OutputStream out = response.getOutputStream();
	        out.write(cellPhoneDao.findQr(1));
	        out.flush();
	    } catch (Exception e) {
	         e.printStackTrace();
	    } finally {
	          }
	    }*/
}
