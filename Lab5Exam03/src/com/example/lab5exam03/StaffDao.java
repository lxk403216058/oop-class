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

	    // 向staff表中添加一条数据
	    public void insert(Staff data) {
	        try {
	            dao.create(data);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // 删除staff表中的一条数据
	    public void delete(Staff data) {
	        try {
	            dao.delete(data);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // 修改staff表中的一条数据
	    public void update(Staff data) {
	        try {
	            dao.update(data);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // 查询staff表中的所有数据
	    public List<Staff> selectAll() {
	        List<Staff> users = null;
	        try {
	            users = dao.queryForAll();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    // 根据ID取出用户信息
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
