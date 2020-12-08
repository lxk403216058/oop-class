package com.bank.dao;

import com.bank.entity.User;

public interface UserDao {
	//增加用户信息
	int save(User user);
	//删除用户信息
	int delete(int cno);
	//修改金额
	int updateAmount(int cno,int amount);
	//查询用户信息
	User findByCno(int cno);
	//修改密码
	int updatePassword(int cno,String password);
	//根据身份证号查询用户信息
	User findByID(String ID);

}
