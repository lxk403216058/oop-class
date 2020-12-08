package com.example.lab7exer01;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;

import android.content.Context;

public class ScheduleDao {
	private Context context;
    // ORMLite�ṩ��DAO����󣬵�һ��������Ҫ���������ݱ�ӳ��ɵ�ʵ���ࣻ�ڶ������������ʵ������ID����������
    private Dao<Schedule, Integer> dao;

    public ScheduleDao(Context context) {
        this.context = context;
        try {
            this.dao = DataHelper.getInstance(context).getDao(Schedule.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // �������
    public void insert(Schedule data) {
        try {
            dao.create(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ɾ������
    public void delete(Schedule data) {
        try {
            dao.delete(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // �޸�����
    public void update(Schedule data) {
        try {
            dao.update(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ͨ��ID��ѯһ������
    public Schedule queryById(int id) {
    	Schedule article = null;
        try {
            article = dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    // ͨ��������ѯ���¼��ϣ�ͨ���û�ID���ң�
    public List<Schedule> queryByUserId(int user_id) {
        try {
            return dao.queryBuilder().where().eq(Schedule.COLUMNNAME_USER, user_id).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
