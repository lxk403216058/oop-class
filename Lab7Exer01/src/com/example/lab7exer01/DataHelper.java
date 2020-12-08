package com.example.lab7exer01;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataHelper extends OrmLiteSqliteOpenHelper{

	// ���ݿ�����
    public static final String DATABASE_NAME = "mydb.db";

    // ����ĵ���ʵ��
    private static DataHelper instance;

    // �洢APP�����е�DAO�����Map����
    private Map<String, Dao> daos = new HashMap<String, Dao>();

    // ��ȡ���൥������ķ���
    public static synchronized DataHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (DataHelper.class) {
                if (instance == null) {
                    instance = new DataHelper(context);
                }
            }
        }
        return instance;
    }

    // ˽�еĹ��췽��
    private DataHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    // ���ݴ����DAO��·����ȡ�����DAO�ĵ�������Ҫô��daos���Map�л�ȡ��Ҫô�´���һ��������daos��
    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if (daos.containsKey(className)) {
            dao = daos.get(className);
        }
        if (dao == null) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }

    @Override // �������ݿ�ʱ���õķ���
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Schedule.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // ���ݿ�汾����ʱ���õķ���
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, Schedule.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // �ͷ���Դ
    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }
}
