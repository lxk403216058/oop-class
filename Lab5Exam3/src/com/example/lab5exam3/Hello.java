package com.example.lab5exam3;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "staff")
public class Hello {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "sex")
    private String sex;
    @DatabaseField(columnName = "department")
    private String department;
    @DatabaseField(columnName = "salary")
    private float salary;
    //空的构造方法一定要有，否则数据库会创建失败
    public  Hello(){

    }
	public Hello(String name, String sex, String department, float salary) {
		super();
		this.name = name;
		this.sex = sex;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Hello [id=" + id + ", name=" + name + ", sex=" + sex + ", department=" + department + ", salary="
				+ salary + "]";
	}
    
}