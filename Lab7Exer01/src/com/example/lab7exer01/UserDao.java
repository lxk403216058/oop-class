package com.example.lab7exer01;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;

import android.content.Context;

public class UserDao {
	private Context context;
    // ORMLite�ṩ��DAO����󣬵�һ��������Ҫ���������ݱ�ӳ��ɵ�ʵ���ࣻ�ڶ������������ʵ������ID����������
    private Dao<User, Integer> dao;

    public UserDao(Context context) {
        this.context = context;
        try {
            this.dao = DataHelper.getInstance(context).getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ��user�������һ������
    public void insert(User data) {
        try {
            dao.create(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ɾ��user���е�һ������
    public void delete(User data) {
        try {
            dao.delete(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // �޸�user���е�һ������
    public void update(User data) {
        try {
            dao.update(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ��ѯuser���е���������
    public List<User> selectAll() {
        List<User> users = null;
        try {
            users = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // ����IDȡ���û���Ϣ
    public User queryById(int id) {
    	User user = null;
        try {
            user = dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
}
