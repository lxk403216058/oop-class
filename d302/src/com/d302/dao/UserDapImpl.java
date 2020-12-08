package com.d302.dao;

public class UserDapImpl implements UserDao {

	@Override
	public boolean login(String name, String password) {
		boolean loginFlag = false;
		if ("≤Ã–Ï¿§".equals(name)&&"123456".equals(password)) {
			loginFlag = true;
		}
		return loginFlag;
	}

}
