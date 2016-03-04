package com.hantian.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hantian.demo.pojo.Department;
import com.hantian.demo.pojo.DepartmentTree;
import com.hantian.demo.service.IDepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Integer edit(@ModelAttribute Department department) {
		
		int status = 0;
		
		try {
			departmentService.saveOrUpdate(department);
			status = 1;
		} catch (Exception e) {
			e.printStackTrace();
			status = -1;
		}
		return status;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Integer delete(Integer id) {
		int status = 0;
		try {

			departmentService.delete(id);
			status = 1;
		} catch (Exception e) {
			e.printStackTrace();
			status = -1;
		}
		return status;
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<Department> list() {
		List<Department> departments = departmentService.list();
		return departments;
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView andView = new ModelAndView("department/index");
		return andView;
	}

	@RequestMapping("/listTree")
	@ResponseBody
	public List<DepartmentTree> listTree() {
		List<Department> departments = departmentService.list();
		List<DepartmentTree> departmentTrees = toDepartmentTrees(departments);
		return departmentTrees;
	}

	private List<DepartmentTree> toDepartmentTrees(List<Department> departments) {
		List<DepartmentTree> departmentTrees = new ArrayList<DepartmentTree>();
		for (int i = 0; null != departments && i < departments.size(); i++) {
			int flag = 0;
			for (int j = 0; null != departmentTrees
					&& j < departmentTrees.size(); j++) {
				if (null != departments.get(i).getParent()
						&& departments.get(i).getParent().getId() == departmentTrees
								.get(j).getId()) {
					flag = 1;
					DepartmentTree departmentTree = new DepartmentTree();
					departmentTree.setId(departments.get(i).getId());
					departmentTree.setTitle(departments.get(i).getName());
					departmentTree.setKey(departments.get(i).getId() + "");
					departmentTrees.get(j).getChildren().add(departmentTree);
					break;

				}
			}
			if (flag == 0) {
				DepartmentTree departmentTree = new DepartmentTree();
				departmentTree.setId(departments.get(i).getId());
				departmentTree.setTitle(departments.get(i).getName());
				departmentTree.setKey(departments.get(i).getId() + "");
				departmentTrees.add(departmentTree);
			}
		}
		return departmentTrees;
	}

	@RequestMapping("find")
	@ResponseBody
	public Department find(Integer id) {
		Department department = departmentService.findById(id);
		return department;
	}

	@RequestMapping("/editView")
	public ModelAndView editView(String state, Integer id) {
		ModelAndView modelAndView = new ModelAndView("/department/edit");
		modelAndView.addObject("state", state);
		modelAndView.addObject("id", id);
		return modelAndView;
	}
}
