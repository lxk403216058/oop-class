package com.example.lab5exam3;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.DatabaseConnection;
import android.content.Context;

public class HelloDao {
    private Dao<Hello,Integer> helloDao;
    private DataHelper dataHelper;

    /**
     * ���췽������ȡ���ݿ������ʵ����ͨ������class����õ���Ӧ��Dao
     * @param context
     */
    public HelloDao(Context context){
        try {
            dataHelper = DataHelper.getHeper(context);
            helloDao = dataHelper.getHelloDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���һ����¼
     * @param hello
     */
    public void add(Hello hello){
        try {
            helloDao.create(hello);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * �������������
     * ��������
     * �ر��Զ��ύ
     * @param hellos
     */
    public void addList(List<Hello> hellos){
        try{
            DatabaseConnection conn = helloDao.startThreadConnection();
            Savepoint savepoint = conn.setSavePoint(null);
            helloDao.setAutoCommit(conn,false);
            for(Hello hello : hellos){
                helloDao.createOrUpdate(hello);
            }
            conn.commit(savepoint);
            helloDao.endThreadConnection(conn);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * ɾ��һ����¼
     * @param hello
     */
    public void delete(Hello hello){
        try {
            helloDao.delete(hello);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ����һ����¼
     * @param hello
     */
    public void update(Hello hello){
        try {
            helloDao.update(hello);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ѯһ����¼
     * @param id
     * @return
     */
    public Hello queryForId(int id){
        Hello hello = null;
        try {
            hello = helloDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hello;
    }

    /**
     * ��ѯ���еļ�¼
     * @return
     */
    public List<Hello> queryForAll(){
        List<Hello> hellos = new ArrayList<Hello>();
        try {
            hellos = helloDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hellos;
    }
}