package com.empmgr.dao;

import java.util.List;
import com.empmgr.entity.Employee;

public interface EmployeeDao {
	//��������
	int save(Employee emp);
	//ɾ������
	int delete(int id);
	//��ѯ����
	Employee findById(int id);
	//�޸�����
	int update(Employee emp);
	//ģ����ѯ
	List<Employee> findAll(String keyword);
}
