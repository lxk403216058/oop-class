package com.bank.service;

import com.bank.entity.User;

public interface UserService {
	//�洢�û���Ϣ
	int saveUser(User user);
	
	//ɾ���û���Ϣ
	int deleteUser(int cno);
	
	//�޸��˻����
	int updateAmount(int cno,int aamount);
	
	//��ѯ�˻���Ϣ
	User findUser(int cno);
	
	//�޸��û�����
	int updatePassword(int cno, String password);
	
	//�������֤�Ų�ѯ�û���Ϣ
	User findUserID(String ID);
	

}
