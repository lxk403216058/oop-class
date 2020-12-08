package com.empmgr.controller;

import com.empmgr.util.Input;

public class Menu {
	
	//构造方法，循环执行菜单选择操作
		public Menu(){
			while (true){
				show();
			}
		}
		
		private void show() {
			//给出操作提示，并根据选择的菜单进行相应的业务操作
			System.out.println("   ======    员工管理系统    ======");
			System.out.println("   1.增加员工信息");
			System.out.println("   2.删除员工");
			System.out.println("   3.更新员工信息");
			System.out.println("   4.根据工号查询员工信息");
			System.out.println("   5.根据关键字查询员工信息");
			System.out.println("   6.退出系统");
			//从键盘获取操作选项
			int key = Input.getInt("请选择操作项(1-6)", "选择错误，重新选择:");
			
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
				System.out.println("...系统已经退出！");
				System.exit(1);
			default:
				System.out.println("此操作不在选项之内！");
			}
		}

}
