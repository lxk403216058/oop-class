package com.empmgr.service;

import java.util.List;
import com.empmgr.entity.Employee;

public interface EmployeeService {
	
	    //����Ա����Ϣ�ķ���
		int saveEmpolyee(Employee emp);
		
		//ɾ��Ա����Ϣ
		int deleteEmpolyee(int empno);
		
		//����id����һ��Ա������Ϣ
		int updateEmpolyee(Employee emp);
		
		//��ѯһ��Ա������Ϣ
		Employee getEmpolyee(int empno);
		
		//���ݴ���ؼ���ģ����ѯԱ����Ϣ
		List<Employee> findAll(String keyword);

}
