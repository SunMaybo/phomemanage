package com.green.phonemanage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.green.phonemanage.model.MenuItem;
@Controller
public class LoginController {
	@RequestMapping(value="/web/toIndex",method=RequestMethod.GET)
public ModelAndView loginToIndex(String loginName,int role,int userId){
	ModelAndView andView=new ModelAndView("index");
	andView.addObject("loginName",loginName);
	andView.addObject("role", role);
	andView.addObject("userId", userId);
	return andView;
}
	
}
