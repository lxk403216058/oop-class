package com.example.lab5exam03;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	public DatabaseHelper(Context context, String databaseName, CursorFactory factory, int databaseVersion) {
		super(context, "staff.db", null, 1);
		// TODO Auto-generated constructor stub
	}
	private static DatabaseHelper databaseHelper = null;
	
	public synchronized static DatabaseHelper getIntstance(Context context){
		if (databaseHelper == null) {
			databaseHelper = new DatabaseHelper(context,"staff",null,1);
		}
		return databaseHelper;
	}
	
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
		// TODO Auto-generated method stub
		try {
			TableUtils.createTable(connectionSource,Staff.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int arg2, int arg3) {
		// TODO Auto-generated method stub
		try {
			TableUtils.dropTable(connectionSource,Staff.class,true);
			
			onCreate(sqLiteDatabase,connectionSource);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public DatabaseHelper getDatabaseHelper(){ 
		return DatabaseHelper.getIntstance(MainActivity.this);
	}
	public Dao<Staff, Integer> getStaffDao() throws SQLException{
		return getDatabaseHelper().getDao(Staff.class);
	}
	

}
