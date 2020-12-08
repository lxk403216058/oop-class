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
	
	//�Ӽ��̻�ȡԱ����Ϣ������������ݿ�
		public static void saveEmpolyee(){
			//1.����Ա���Ķ��󲢳�ʼ��������
			
			String ename = Input.getString("����Ա��������:","Ա��������Ϊ�գ�����������:");
			float salary = Input.getData("���빤��","���ʲ���Ϊ��");
			Date birthday = Input.getDate("�����������:","�������ڲ���Ϊ�գ�����������:");
			String dname = Input.getString("����:","�������Ʋ���Ϊ�գ�����������:");
			
			
			Employee emp = new Employee(ename,salary,birthday,dname);
			//2.���÷���㣬���䱣�浽���ݿ���
			int i = service.saveEmpolyee(emp);
			if (i>0){
				System.out.println("Ա������Ϣ����ɹ���("+ service.findAll(emp.getEname()).get(0) +")");
			}else {
				System.out.println("Ա������Ϣ����ʧ�ܣ�");
			}
		}
		
		//��ȡ�����Ϣ
		public static void findById(){
			//1.����һ������ID
			int empno = (int)Input.getData("�������Ա���Ĺ���:", "���Ų���Ϊ��:");
			//2.��ѯ��ID��Ϣ
			Employee emp = service.getEmpolyee(empno);
			if (emp != null) {
				System.out.println("��ѯ���"+service.getEmpolyee(empno));
			} else {
				System.out.println("�˹���:"+empno+"��Ա��������");
			}
		}
		
		//ɾ��Ա������Ϣ
		public static void deteleEmpolyee(){
			//1.�Ӽ��̻��Ҫɾ����Ա���Ĺ���
			Employee emp = null;
			int empno = (int)Input.getData("����Ա���Ĺ���", "�������󹤺Ų���Ϊ����Ϊ����");
			//�жϴ˹��ŵ�Ա���Ƿ����
			emp = service.getEmpolyee(empno);
			
			//3.������,����÷����ɾ������
			if (emp != null) {
				System.out.println(emp);
				service.deleteEmpolyee(empno);
				System.out.println("��������Ϊ��"+empno+"��Ա���Ѿ�ɾ��");
			} else {
				System.out.println("ɾ��ʧ�ܣ��˹���:"+empno+"��Ա��������");
			}
			
		}
		
		//�޸�Ա������Ϣ
		public static void updateEmpolyee() {
			//1.�Ӽ��̻�ȡҪ�޸�Ա���Ĺ���
			int empno  = Input.getInt("����Ҫ����Ա���Ĺ���", "�������󹤺Ų���Ϊ����Ϊ������");
			//2.��ѯ�˹��ŵ�Ա���Ƿ����
			Employee emp = service.getEmpolyee(empno);
			if (emp != null) {
				String ename = Input.getString("����Ա����(ԭԱ����"+ emp.getEname() +")", "��������Ϊ�գ�");
				emp.setEname(ename);
				float salary = Input.getData("����Ա���Ĺ���(ԭ����"+ emp.getSalary() +"):", "��������������һ����ֵ:");
				emp.setSalary(salary);
				Date birthday = Input.getDate("�޸ĳ�������("+ emp.getBirthday() +"):", "���ݸ�ʽ����:");
				emp.setBirthday(birthday);
				
				String dname = Input.getString("���²���(ԭ����"+ emp.getDname() +")��", "���Ų���Ϊ��:");
				emp.setDname(dname);
				
				
				int i = service.updateEmpolyee(emp);
			if (i>0) {
				System.out.println("Ա������Ϣ���³ɹ���");
			} else {
				System.out.println("Ա������Ϣ����ʧ�ܣ�");
			}
			}else {
				System.out.println("����ʧ�ܣ��˹��ţ�"+empno+" ��Ա��������");
			}
			//3.�����ڣ��Ե�ǰ�����Ϣ���и���
			
			//4.���÷���㣬�����ºõ������ύ
			
		}
		
		//ģ����ѯ
		public static void findAll(){
			//1.�ȴӼ��̻��Ҫ��ѯ�Ĺؼ���
			List<Employee> list= new ArrayList<Employee>();
			
			String keyword = Input.getKeyword("�������ѯ�Ĺؼ���,��������������ո�Ͳ�ѯ����:");
			//2.���÷�����ѯ����
			list = service.findAll(keyword);
			//3.�ж����ݼ��Ĵ�С������ʾ
			int size = list.size();
			if (size>0) {
				System.out.println("�鵽��������:");
				for(Employee b: list)
					System.out.println(b);
			} else {
				System.out.println("....û�в鵽������ݣ�");
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
