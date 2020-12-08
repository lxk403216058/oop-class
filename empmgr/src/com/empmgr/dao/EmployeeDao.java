package com.empmgr.dao;

import java.util.List;
import com.empmgr.entity.Employee;

public interface EmployeeDao {
	//增加数据
	int save(Employee emp);
	//删除数据
	int delete(int id);
	//查询数据
	Employee findById(int id);
	//修改数据
	int update(Employee emp);
	//模糊查询
	List<Employee> findAll(String keyword);
}
