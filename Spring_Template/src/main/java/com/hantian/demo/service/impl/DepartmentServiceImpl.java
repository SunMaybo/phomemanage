package com.hantian.demo.service.impl;

import org.springframework.stereotype.Service;

import com.hantian.demo.dao.impl.DepartmentDaoImpl;
import com.hantian.demo.service.IDepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl extends DepartmentDaoImpl implements IDepartmentService{

}
