package com.green.phonemanage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/web/bar/")
public class BarViewController {
	@RequestMapping(value = "status", method = RequestMethod.GET)
	public ModelAndView toStatus() {
		ModelAndView andView = new ModelAndView("/bar/status");
		
		return andView;
	}
	@RequestMapping(value = "address", method = RequestMethod.GET)
	public ModelAndView toAddress() {
		ModelAndView andView = new ModelAndView("/bar/address");
		
		return andView;
	}
	@RequestMapping(value = "brand", method = RequestMethod.GET)
	public ModelAndView toBrand() {
		ModelAndView andView = new ModelAndView("/bar/brand");
		
		return andView;
	}
}
