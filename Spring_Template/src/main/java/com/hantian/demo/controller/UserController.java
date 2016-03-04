package com.hantian.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hantian.demo.pojo.User;
import com.hantian.demo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/edit")
	public void edit(@ModelAttribute User user) {
		
		System.out.println("----");
		try {
			userService.saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("--9987---");
		
	}

	@RequestMapping("/rm")
	@ResponseBody
	public Integer delete(Integer id) {
		int back = 0;
		try {
			back = 1;
			userService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			back = -1;
		}
		return back;
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		Map<String, Object> maps = userService.list(null);
		ModelAndView modelAndView = new ModelAndView("user/index");
		modelAndView.addObject("maps", maps);
		return modelAndView;
	}

	@RequestMapping("/find")
	@ResponseBody
	public User find(int id) {
		User user = userService.findById(id);
		return user;
	}

	@RequestMapping("/editView")
	public ModelAndView editView(String state, Integer id) {
		ModelAndView modelAndView = new ModelAndView("/user/edit");
		modelAndView.addObject("state", state);
		modelAndView.addObject("id", id);
		return modelAndView;
	}
}
