package com.bank.controller;

import com.bank.entity.User;
import com.bank.service.UserService;
import com.bank.service.UserServiceImp;
import com.bank.util.Uuid;

public class UserOperator {
	private static UserService service = new UserServiceImp();
	
	//�ӽ����ȡ�û���Ϣ������������ݿ�(����)
	public static void saveUser(String name,String idno,String password,String type) {
		//1.����һ���û�����ʼ��������
		
		int cno = Uuid.uuidInt();
		int amount = 0;
		String card = Uuid.uuidCard();
		String pno = Uuid.uuidPno();
		
		User user = new User(cno,name,password,type,amount,card,idno,pno);
		//2.���÷���㣬���䱣�浽���ݿ���
		
		int i = service.saveUser(user);
		
		if (i>0){
			System.out.println("�û�����Ϣ����ɹ���("+ user +")");
		}else {
			System.out.println("�û�����Ϣ����ʧ�ܣ�");
		}
	}
	
	//��ѯ�û���Ϣ
	public static User find(int cno) {
		return service.findUser(cno);
	}
	
	//�������֤�Ų�ѯ�û���Ϣ
	public static User findUserID(String ID) {
		return service.findUserID(ID);
	}
	
	//���
	public static void deposit(int cno,int num){
		//1.�ӷ�����ȡ�û���Ϣ
		
		User user = service.findUser(cno);
		
		//2.�����ܽ��
		int amount = 0;
		if (user != null) {
			amount = user.getAmount()+num;
			System.out.println(amount);
		}
		
		//3.���÷���㣬�������ݿ�
		service.updateAmount(cno, amount);
	}
	
	//ȡ��
	public static int withdraw(int cno,int num){
		//1.�ӷ�����ȡ�û���Ϣ
		
		User user = service.findUser(cno);
		
		//2.�����ܽ��
		int amount = 0;
		if (user != null) {
			amount = user.getAmount()-num;
			
			if (amount<0) {
				return -1;
			}
		}
		
		//3.���÷���㣬�������ݿ�
		service.updateAmount(cno, amount);
		
		return 1;
	}
	
	//ת��
	public static int transfer(int cno1,int cno2,int num) {
		User user1 = service.findUser(cno1);
		User user2 = service.findUser(cno2);
		
		int amount1 = 0;
		int amount2 = 0;
		if (user2 != null) {
			amount1 = user1.getAmount()-num;
			amount2 = user2.getAmount()+num;
			if (amount1<0) {
				return -1;
			}
		}
		
		service.updateAmount(cno1, amount1);
		service.updateAmount(cno2, amount2);
		
		return 1;
	}
	
	//�޸�����
	public static void updatePassword(int cno, String password) {
		User user = service.findUser(cno);
		
		if (user != null) {
			service.updatePassword(cno, password);
		}
	}
	
	public static int  verification(int cno,String password) {
		User user = service.findUser(cno);
		
		if (user != null) {
			if (password.equals(user.getPassword())) {
				return 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		//saveUser("cxk", "3261362", "456678", "v");
		//deposit(2, 100000);
		//withdraw(2, 1000);
		//transfer(101189, 2, 900);
		//updatePassword(2, "huiaiuse");
		//System.out.println(findUserID("456789"));
	}

}
