package com.empmgr.entity;

import java.util.Date;

public class Employee {
	private int empno;
    private String ename;
    private float salary;
    private Date birthday;
    private String dname;
    
	public Employee() {
		super();
	}
	
	public Employee(int empno, String ename, float salary, Date birthday, String dname) {
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.birthday = birthday;
		this.dname = dname;
	}

	public Employee(String ename, float salary, Date birthday, String dname) {
		super();
		this.ename = ename;
		this.salary = salary;
		this.birthday = birthday;
		this.dname = dname;
	}

	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", salary=" + salary + ", birthday=" + birthday
				+ ", dname=" + dname + "]";
	}
	
}
