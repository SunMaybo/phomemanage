package com.green.phonemanage.service;

import com.green.phonemanage.model.User;
import com.green.phonemanage.model.UserMsg;

/**
 * @author maybo
 *
 */
public interface IUserService {
	public UserMsg register(User user) ;

	public UserMsg login(User user);

	public UserMsg findUserExist(String loginName);
}
