package com.bank.entity;

public class Person {
	private int qNo;
	private int cNo;
	private int userId;
	private String remark_01;
	private String remark_02;
	
	public Person() {
		super();
	}
	
	public Person(int cNo, int userId, String remark_01, String remark_02) {
		super();
		this.cNo = cNo;
		this.userId = userId;
		this.remark_01 = remark_01;
		this.remark_02 = remark_02;
	}
	
	public Person(int qNo, int cNo, int userId, String remark_01, String remark_02) {
		super();
		this.qNo = qNo;
		this.cNo = cNo;
		this.userId = userId;
		this.remark_01 = remark_01;
		this.remark_02 = remark_02;
	}
	
	public int getqNo() {
		return qNo;
	}
	
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	
	public int getcNo() {
		return cNo;
	}
	
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getRemark_01() {
		return remark_01;
	}
	
	public void setRemark_01(String remark_01) {
		this.remark_01 = remark_01;
	}
	
	public String getRemark_02() {
		return remark_02;
	}
	
	public void setRemark_02(String remark_02) {
		this.remark_02 = remark_02;
	}
	
	

}
