package com.hantian.demo.service.impl;

import org.springframework.stereotype.Service;

import com.hantian.demo.dao.impl.UserDaoImpl;
import com.hantian.demo.service.IUserService;

@Service("userService")
public class UserServiceImpl extends UserDaoImpl implements IUserService{

}
