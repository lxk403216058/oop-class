package com.empmgr.service;

import java.util.List;
import com.empmgr.entity.Employee;

public interface EmployeeService {
	
	    //存入员工信息的方法
		int saveEmpolyee(Employee emp);
		
		//删除员工信息
		int deleteEmpolyee(int empno);
		
		//根据id更新一个员工的信息
		int updateEmpolyee(Employee emp);
		
		//查询一个员工的信息
		Employee getEmpolyee(int empno);
		
		//根据传入关键字模糊查询员工信息
		List<Employee> findAll(String keyword);

}
