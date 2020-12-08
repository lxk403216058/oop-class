package com.empmgr.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/empmgr";
	private static final String USER = "root";
	private static final String PASS = "123";
	
	//1.�������ݿ���������
	static{
		try {
			Class.forName(DRIVER);//ͨ�����������������
		} catch (ClassNotFoundException e) {
			System.out.println("���������Ҳ���������ʧ�ܣ�");
			e.printStackTrace();
		} 
	}
	//2.ͨ������������������ݿ����Ӷ���

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = java.sql.DriverManager.getConnection(URL,USER,PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		//1.�رս����
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//2.�رղ�������
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//3.�ر����Ӷ���
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//����
	public static void main(String[] args){
		System.out.println(DBUtil.getConnection());
	}

}
