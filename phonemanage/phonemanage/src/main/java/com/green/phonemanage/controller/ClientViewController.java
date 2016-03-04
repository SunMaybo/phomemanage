package com.green.phonemanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/web/client")
public class ClientViewController {
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView andView = new ModelAndView("client/index");
		return andView;
	}
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView andView = new ModelAndView("client/edit");
		return andView;
	}
	@RequestMapping(value = "eindex", method = RequestMethod.GET)
	public ModelAndView aedit() {
		ModelAndView andView = new ModelAndView("client/eindex");
		return andView;
	}
}
