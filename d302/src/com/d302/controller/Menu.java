package com.d302.controller;

import java.util.Scanner;

import com.d302.util.Input;

//�˵��࣬����ѡ�����
public class Menu {
	//���췽����ѭ��ִ�в˵�ѡ�����
	public Menu(){
		while (true){
			show();
		}
	}
	
	private void show() {
		//����������ʾ��������ѡ��Ĳ˵�������Ӧ��ҵ�����
		System.out.println("   ======    d302ͼ�����ϵͳ    ======");
		System.out.println("   1.����ͼ����Ϣ");
		System.out.println("   2.ɾ��ͼ��");
		System.out.println("   3.����ͼ����Ϣ");
		System.out.println("   4.����ID��ѯͼ����Ϣ");
		System.out.println("   5.���ݹؼ��ֲ�ѯͼ����Ϣ");
		System.out.println("   6.�˳�ϵͳ");
		//�Ӽ��̻�ȡ����ѡ��
		int key = Input.getInt("��ѡ�������(1-6)", "ѡ���������ѡ��:");
		
		switch (key) {
		case 1:
			Operator.saveBook();
			break;
		case 2:
			Operator.deteleBook();
			break;
		case 3:
			Operator.updateBook();
			break;
		case 4:
			Operator.findById();
		case 5:
			Operator.findAll();
			break;
		case 6:
			System.out.println("...ϵͳ�Ѿ��˳���");
			System.exit(1);
		default:
			System.out.println("�˲�������ѡ��֮�ڣ�");
		}
	}
	
}
