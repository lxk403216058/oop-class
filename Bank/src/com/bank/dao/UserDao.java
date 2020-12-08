package com.bank.dao;

import com.bank.entity.User;

public interface UserDao {
	//�����û���Ϣ
	int save(User user);
	//ɾ���û���Ϣ
	int delete(int cno);
	//�޸Ľ��
	int updateAmount(int cno,int amount);
	//��ѯ�û���Ϣ
	User findByCno(int cno);
	//�޸�����
	int updatePassword(int cno,String password);
	//�������֤�Ų�ѯ�û���Ϣ
	User findByID(String ID);

}
