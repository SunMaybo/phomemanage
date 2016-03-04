package com.green.phonemanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/web/cellphone/")
@Controller
public class CellPhoneViewController {
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView andView = new ModelAndView("cellphone/index");
		return andView;
	}
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView andView = new ModelAndView("cellphone/edit");
		return andView;
	}
	@RequestMapping(value = "aedit", method = RequestMethod.GET)
	public ModelAndView aedit() {
		ModelAndView andView = new ModelAndView("cellphone/aedit");
		return andView;
	}
}
