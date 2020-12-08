package com.empmgr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.empmgr.entity.Employee;
import com.empmgr.service.EmployeeService;
import com.empmgr.service.EmpolyeeServiceImpl;
import com.empmgr.util.Input;

public class Operator {
	private static EmployeeService service = new EmpolyeeServiceImpl();
	
	//从键盘获取员工信息并将其存入数据库
		public static void saveEmpolyee(){
			//1.创建员工的对象并初始化其属性
			
			String ename = Input.getString("输入员工的名称:","员工名不能为空，请重新输入:");
			float salary = Input.getData("输入工资","工资不能为空");
			Date birthday = Input.getDate("输入出生日期:","出生日期不能为空，请重新输入:");
			String dname = Input.getString("部门:","部门名称不能为空，请重新输入:");
			
			
			Employee emp = new Employee(ename,salary,birthday,dname);
			//2.调用服务层，将其保存到数据库中
			int i = service.saveEmpolyee(emp);
			if (i>0){
				System.out.println("员工的信息保存成功！("+ service.findAll(emp.getEname()).get(0) +")");
			}else {
				System.out.println("员工的信息保存失败！");
			}
		}
		
		//获取书的信息
		public static void findById(){
			//1.输入一个整形ID
			int empno = (int)Input.getData("输入待查员工的工号:", "工号不能为空:");
			//2.查询此ID信息
			Employee emp = service.getEmpolyee(empno);
			if (emp != null) {
				System.out.println("查询结果"+service.getEmpolyee(empno));
			} else {
				System.out.println("此工号:"+empno+"的员工不存在");
			}
		}
		
		//删除员工的信息
		public static void deteleEmpolyee(){
			//1.从键盘获得要删除的员工的工号
			Employee emp = null;
			int empno = (int)Input.getData("输入员工的工号", "输入有误工号不能为空且为整数");
			//判断此工号的员工是否存在
			emp = service.getEmpolyee(empno);
			
			//3.若存在,则调用服务层删除数据
			if (emp != null) {
				System.out.println(emp);
				service.deleteEmpolyee(empno);
				System.out.println("上述工号为："+empno+"的员工已经删除");
			} else {
				System.out.println("删除失败！此工号:"+empno+"的员工不存在");
			}
			
		}
		
		//修改员工的信息
		public static void updateEmpolyee() {
			//1.从键盘获取要修改员工的工号
			int empno  = Input.getInt("输入要更新员工的工号", "输入有误工号不能为空且为正整数");
			//2.查询此工号的员工是否存在
			Employee emp = service.getEmpolyee(empno);
			if (emp != null) {
				String ename = Input.getString("更新员工名(原员工名"+ emp.getEname() +")", "书名不能为空：");
				emp.setEname(ename);
				float salary = Input.getData("更新员工的工资(原工资"+ emp.getSalary() +"):", "输入有误，请输入一个数值:");
				emp.setSalary(salary);
				Date birthday = Input.getDate("修改出生日期("+ emp.getBirthday() +"):", "数据格式错误:");
				emp.setBirthday(birthday);
				
				String dname = Input.getString("更新部门(原部门"+ emp.getDname() +")：", "部门不能为空:");
				emp.setDname(dname);
				
				
				int i = service.updateEmpolyee(emp);
			if (i>0) {
				System.out.println("员工的信息更新成功！");
			} else {
				System.out.println("员工的信息更新失败！");
			}
			}else {
				System.out.println("更新失败！此工号："+empno+" 的员工不存在");
			}
			//3.若存在，对当前书的信息进行更新
			
			//4.调用服务层，将更新好的数据提交
			
		}
		
		//模糊查询
		public static void findAll(){
			//1.先从键盘获得要查询的关键字
			List<Employee> list= new ArrayList<Employee>();
			
			String keyword = Input.getKeyword("请输入查询的关键字,如果不输入或输入空格就查询所有:");
			//2.调用服务层查询数据
			list = service.findAll(keyword);
			//3.判断数据集的大小进行显示
			int size = list.size();
			if (size>0) {
				System.out.println("查到以下数据:");
				for(Employee b: list)
					System.out.println(b);
			} else {
				System.out.println("....没有查到相关数据！");
			}
		}
		
		public static void main(String[] args) {
			//updateEmpolyee();
			//deteleEmpolyee();
			//saveEmpolyee();
			//findById();
			//findAll();
		}

}
