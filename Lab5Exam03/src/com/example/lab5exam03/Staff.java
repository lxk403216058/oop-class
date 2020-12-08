package com.example.lab5exam03;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.*;

@DatabaseTable(tableName = "staff")
public class Staff {
	@DatabaseField(generatedId = true, columnName = "_id", dataType=DataType.INTEGER)
    private int id;
    @DatabaseField(columnName = "name", dataType=DataType.STRING)
    private String name;
    @DatabaseField(columnName = "sex", dataType=DataType.STRING)
    private char sex;
    @DatabaseField(columnName = "department", dataType=DataType.STRING)
    private String department;
    @DatabaseField(columnName = "salary", dataType=DataType.FLOAT)
    private float salary;
    
	public Staff() {
		
	}
	public Staff(String name, char sex, String department, float salary) {
		super();
		this.name = name;
		this.sex = sex;
		this.department = department;
		this.salary = salary;
	}

	public Staff(int id, String name, char sex, String department, float salary) {
		super();
		this.id = id;
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
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
		return "Staff [id=" + id + ", name=" + name + ", sex=" + sex + ", department=" + department + ", salary="
				+ salary + "]";
	}

}
