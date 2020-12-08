package com.d302.service;

import com.d302.dao.UserDao;
import com.d302.dao.UserDapImpl;

public class UserServiceImpl implements UserService {

	@Override
	public boolean login(String name, String password) {
		UserDao dao =new UserDapImpl();
		return dao.login(name, password);
	}

}
