package com.example.lab7exer01;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Schedule")
public class Schedule {
	public static final String COLUMNNAME_ID = "id";
    public static final String COLUMNNAME_STROKENAME = "strokeName";
    public static final String COLUMNNAME_STRKECONTENT = "strokeContent";
    public static final String COLUMNNAME_STRKEDATE= "strokeDate";
    public static final String COLUMNNAME_USER = "user_id";
	
	@DatabaseField(generatedId = true,columnName=COLUMNNAME_ID)
	private int id;
	@DatabaseField(columnName = COLUMNNAME_STROKENAME)
	private String strokeName;
	@DatabaseField(columnName = COLUMNNAME_STRKECONTENT)
	private String strokeContent;
	@DatabaseField(columnName = COLUMNNAME_STRKEDATE)
	private String strokeDate;
	@DatabaseField(columnName = COLUMNNAME_USER, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true,
            foreignColumnName = User.COLUMNNAME_ID)
	private User user_id;
	public Schedule() {
		
	}
	public Schedule(String strokeName, String strokeContent, String strokeDate, User user_id) {
		super();
		this.strokeName = strokeName;
		this.strokeContent = strokeContent;
		this.strokeDate = strokeDate;
		this.user_id = user_id;
	}
	public Schedule(int id, String strokeName, String strokeContent, String strokeDate, User user_id) {
		super();
		this.id = id;
		this.strokeName = strokeName;
		this.strokeContent = strokeContent;
		this.strokeDate = strokeDate;
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStrokeName() {
		return strokeName;
	}
	public void setStrokeName(String strokeName) {
		this.strokeName = strokeName;
	}
	public String getStrokeContent() {
		return strokeContent;
	}
	public void setStrokeContent(String strokeContent) {
		this.strokeContent = strokeContent;
	}
	public String getStrokeDate() {
		return strokeDate;
	}
	public void setStrokeDate(String strokeDate) {
		this.strokeDate = strokeDate;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return strokeName + "\n" + strokeContent
				+ "\n" + strokeDate + "\n";
	}
}
