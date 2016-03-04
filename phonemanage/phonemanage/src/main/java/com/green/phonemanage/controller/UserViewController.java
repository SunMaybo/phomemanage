package com.green.phonemanage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/web/user/")
public class UserViewController {
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView andView = new ModelAndView("/user/index");
		
		return andView;
	}
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView andView = new ModelAndView("/user/edit");
		return andView;
	}
	@RequestMapping(value = "edit/pwd", method = RequestMethod.GET)
	public ModelAndView editPwd() {
		ModelAndView andView = new ModelAndView("/user/pwdedit");
		return andView;
	}

}
