package a;

import java.sql.*;

public class JavaDB {
	public static void main(String[] args) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=TSJY";//���ݿ����ָ���Ϊ���Լ������ݿ����֣���������
		try {
			Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		}
		System.out.println("���ݿ������ɹ�");
		try {
			String user = "sa";// ���Լ��������û����ֺ����룡����������������������
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB,user,password);// �������ݿ����
			System.out.println("�������ݿ�ɹ�");
			Statement stmt = con.createStatement();// ����SQL�������
			
			System.out.println("��ѯ");
			System.out.println("��ʼ��ȡ����");
			ResultSet rs = stmt.executeQuery("SELECT * FROM login");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				System.out.println(rs.getString("username") + "\t"
						+ rs.getString("password"));
			}
			System.out.println("��ȡ���");
			// �ر�����
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}
}
