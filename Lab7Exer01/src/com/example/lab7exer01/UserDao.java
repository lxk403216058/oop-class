package com.example.lab7exer01;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;

import android.content.Context;

public class UserDao {
	private Context context;
    // ORMLite提供的DAO类对象，第一个泛型是要操作的数据表映射成的实体类；第二个泛型是这个实体类中ID的数据类型
    private Dao<User, Integer> dao;

    public UserDao(Context context) {
        this.context = context;
        try {
            this.dao = DataHelper.getInstance(context).getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 向user表中添加一条数据
    public void insert(User data) {
        try {
            dao.create(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除user表中的一条数据
    public void delete(User data) {
        try {
            dao.delete(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改user表中的一条数据
    public void update(User data) {
        try {
            dao.update(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查询user表中的所有数据
    public List<User> selectAll() {
        List<User> users = null;
        try {
            users = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // 根据ID取出用户信息
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
