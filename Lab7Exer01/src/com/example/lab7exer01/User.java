package com.example.lab7exer01;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "User")
public class User {
	public static final String COLUMNNAME_ID = "id";
	public static final String COLUMNNAME_Name = "name";
	public static final String COLUMNNAME_PASSWORD = "password";
	
	@DatabaseField(generatedId = true, columnName = COLUMNNAME_ID)
	private int id;
	@DatabaseField(columnName = COLUMNNAME_Name)
	private String name;
	@DatabaseField(columnName = COLUMNNAME_PASSWORD)
	private String password;
	@ForeignCollectionField(eager = true)
	private ForeignCollection<Schedule> schedules;
	public User() {
		
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public User(int id, String name, String password, ForeignCollection<Schedule> schedules) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.schedules = schedules;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ForeignCollection<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(ForeignCollection<Schedule> schedules) {
		this.schedules = schedules;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", schedules=" + schedules + "]";
	}
	
}
