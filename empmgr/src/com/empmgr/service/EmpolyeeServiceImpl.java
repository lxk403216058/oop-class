package com.empmgr.service;

import java.util.List;

import com.empmgr.dao.EmployeeDao;
import com.empmgr.dao.EmployeeDaoImp;
import com.empmgr.entity.Employee;

public class EmpolyeeServiceImpl implements EmployeeService {
	private EmployeeDao dao;
	
	public EmpolyeeServiceImpl() {
		this.dao = new EmployeeDaoImp();
	}
	
	@Override
	public int saveEmpolyee(Employee emp) {
		if (emp != null) {
			return dao.save(emp);
		}
		
		return -1;
	}

	@Override
	public int deleteEmpolyee(int empno) {
		
		Employee emp = dao.findById(empno);
		if (emp != null) {
			return this.dao.delete(empno);
		}
		
		return -1;
	}

	@Override
	public int updateEmpolyee(Employee emp) {
		
		Employee e = this.dao.findById(emp.getEmpno());
		if (e != null) {
			return this.dao.update(emp);
		}
		
		return -1;
	}

	@Override
	public Employee getEmpolyee(int empno) {
		return dao.findById(empno);
	}

	@Override
	public List<Employee> findAll(String keyword) {
		List<Employee> list = null;
		
		if (keyword == null || "".equals(keyword.trim())){
			keyword = "";
		}
		
		return this.dao.findAll(keyword);
		
	}
	
	public static void main(String[] args) {
		EmployeeService service = new EmpolyeeServiceImpl();
		//update(service);
		//save(service);
		//service.deleteEmpolyee(6);
		//findAll(service);
		//Employee emp = service.getEmpolyee(4);
		//System.out.println(emp);
	}

	private static void findAll(EmployeeService service) {
		List<Employee> list = service.findAll("");
		for (Employee emp: list)
			System.out.println(emp);
	}

	private static void update(EmployeeService service) {
		Employee emp = new Employee(3,"呵呵",1213.1F,new java.util.Date(),"市场部");
		service.updateEmpolyee(emp);
	}

	private static void save(EmployeeService service) {
		Employee emp = new Employee("周超",1253.1F,new java.util.Date(),"唱跳rap");
		service.saveEmpolyee(emp);
	}

}
