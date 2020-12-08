package com.example.lab5exam03;

import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import android.content.Context;

public class StaffDao {
	private Dao<Staff, Integer> dao;
	private Context context;
	
	 public StaffDao(Context context) {
	        this.context = context;
	        try {
	            this.dao = DatabaseHelper.getInstance(context).getDao(Staff.class);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // ��staff�������һ������
	    public void insert(Staff data) {
	        try {
	            dao.create(data);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // ɾ��staff���е�һ������
	    public void delete(Staff data) {
	        try {
	            dao.delete(data);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // �޸�staff���е�һ������
	    public void update(Staff data) {
	        try {
	            dao.update(data);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // ��ѯstaff���е���������
	    public List<Staff> selectAll() {
	        List<Staff> users = null;
	        try {
	            users = dao.queryForAll();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    // ����IDȡ���û���Ϣ
	    public Staff queryById(int id) {
	    	Staff user = null;
	        try {
	            user = dao.queryForId(id);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }

}
