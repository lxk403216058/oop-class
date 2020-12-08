package com.example.lab5exam3;

import java.sql.SQLException;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataHelper extends OrmLiteSqliteOpenHelper{

    private static  final  String TABLE_NAME = "test.db";
    /**
     * helloDao 没张表对应一个
     */
    private Dao<Hello,Integer> helloDao = null;

    /**构造方法*/
    public DataHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }
    //创建数据表
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,Hello.class);
            Log.d("jiejie","数据库创建成功");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d("jiejie","数据库更新成功");
        }
    }
    //数据库更新
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource,Hello.class,true);
            onCreate(sqLiteDatabase,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private static  DataHelper instance;
    public static  synchronized  DataHelper getHeper(Context context){
        if(instance == null){
            synchronized (DataHelper.class){
                if(instance == null){
                    instance = new DataHelper(context);
                }
            }
        }
        return instance;
    }
    public Dao<Hello,Integer> getHelloDao() throws  SQLException{
        if(helloDao == null){
            helloDao = getDao(Hello.class);
        }
        return helloDao;
    }
    public  synchronized void clearData(Class<Hello> clase){
        try {
            TableUtils.clearTable(connectionSource,clase);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放资源
     */
    @Override
    public void close() {
        super.close();
        helloDao = null;
    }
}

