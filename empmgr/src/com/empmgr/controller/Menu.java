package com.empmgr.controller;

import com.empmgr.util.Input;

public class Menu {
	
	//���췽����ѭ��ִ�в˵�ѡ�����
		public Menu(){
			while (true){
				show();
			}
		}
		
		private void show() {
			//����������ʾ��������ѡ��Ĳ˵�������Ӧ��ҵ�����
			System.out.println("   ======    Ա������ϵͳ    ======");
			System.out.println("   1.����Ա����Ϣ");
			System.out.println("   2.ɾ��Ա��");
			System.out.println("   3.����Ա����Ϣ");
			System.out.println("   4.���ݹ��Ų�ѯԱ����Ϣ");
			System.out.println("   5.���ݹؼ��ֲ�ѯԱ����Ϣ");
			System.out.println("   6.�˳�ϵͳ");
			//�Ӽ��̻�ȡ����ѡ��
			int key = Input.getInt("��ѡ�������(1-6)", "ѡ���������ѡ��:");
			
			switch (key) {
			case 1:
				Operator.saveEmpolyee();;
				break;
			case 2:
				Operator.deteleEmpolyee();;
				break;
			case 3:
				Operator.updateEmpolyee();;
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
