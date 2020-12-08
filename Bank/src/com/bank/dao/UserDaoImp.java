package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bank.entity.User;
import com.bank.util.DBUtil;


public class UserDaoImp implements UserDao {

	@Override
	public int save(User user) {
		int i=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user(cno,cname,password,type,amount,card,idno,pno)"+"values(?,?,?,?,?,?,?,?)";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setInt(1, user.getID());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getType());
			pstmt.setInt(5, user.getAmount());
			pstmt.setString(6, user.getCardNo());
			pstmt.setString(7, user.getIDNo());
			pstmt.setString(8, user.getPno());
			
			i = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("���ݱ���ʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(null,pstmt,conn);
		}
		
		return i;
	}

	@Override
	public int delete(int cno) {
		int i=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from user where cno = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setInt(1, cno);//���ò���
			
			i = pstmt.executeUpdate();//ִ��ɾ������
		}catch(Exception e){
			System.out.println("����ɾ��ʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(null,pstmt,conn);
		}
		
		return i;
	}

	@Override
	public int updateAmount(int cno,int amount) {
		int i=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		User user = findByCno(cno);
		if (user == null) 
			return -1;
		String sql = "update user set amount = ? where cno = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setInt(1, amount);
			pstmt.setInt(2, cno);
			
			i = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("�����޸�ʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(null,pstmt,conn);
		}
		
		return i;
	}

	@Override
	public User findByCno(int cno) {
		User user = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "select cno,cname,password,type,amount,card,idno,pno from user where cno = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setInt(1, cno);//���ò���
			
			rs = pstmt.executeQuery();//ִ�в�ѯ
			while (rs.next()){//������ѯ�Ľ����
				String name = rs.getString(2);
				String password = rs.getString(3);
				String type = rs.getString(4);
				int amount = rs.getInt(5);
				String card = rs.getString(6);
				String idno = rs.getString(7);
				String pno = rs.getString(8);
				
				user = new User(cno,name,password,type,amount,card,idno,pno);
			}
		}catch(Exception e){
			System.out.println("����cno��ѯʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(rs,pstmt,conn);
		}
		
		return user;
	}

	@Override
	public int updatePassword(int cno,String password) {
		int i=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		User user = findByCno(cno);
		if (user == null) 
			return -1;
		String sql = "update user set password = ? where cno = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setString(1, password);
			pstmt.setInt(2, cno);
			
			i = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("�����޸�ʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(null,pstmt,conn);
		}
		
		return i;
	}
	
	@Override
	public User findByID(String ID) {
		User user = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "select cno,cname,password,type,amount,card,idno,pno from user where IDno = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setString(1, ID);//���ò���
			
			rs = pstmt.executeQuery();//ִ�в�ѯ
			while (rs.next()){//������ѯ�Ľ����
				int cno = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String type = rs.getString(4);
				int amount = rs.getInt(5);
				String card = rs.getString(6);
				
				String pno = rs.getString(8);
				
				user = new User(cno,name,password,type,amount,card,ID,pno);
			}
		}catch(Exception e){
			System.out.println("����id��ѯʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(rs,pstmt,conn);
		}
		
		return user;
	}
	
	public static void main(String[] args) {
		//save();
		//find();
		//updateAmount();
		//updatePassword();
		//delete();
		UserDao dao = new UserDaoImp();
		User user = dao.findByID("45679");
		System.out.println(user);
	}

	private static void delete() {
		UserDao dao = new UserDaoImp();
		int i = dao.delete(1);
		if(i>0){
			System.out.println("����ɾ���ɹ�");
		}else{
			System.out.println("����ɾ��ʧ��");
		}
	}

	private static void updatePassword() {
		UserDao dao = new UserDaoImp();
		int i = dao.updatePassword(1, "sdaad");
		if(i>0){
			System.out.println("�����޸ĳɹ�");
		}else{
			System.out.println("�����޸�ʧ��");
		}
	}

	private static void updateAmount() {
		UserDao dao = new UserDaoImp();
		int i = dao.updateAmount(1, 100);
		if(i>0){
			System.out.println("�����޸ĳɹ�");
		}else{
			System.out.println("�����޸�ʧ��");
		}
	}

	private static void find() {
		UserDao dao = new UserDaoImp();
		User user = dao.findByCno(3);
		System.out.println(user);
	}

	private static void save() {
		UserDao dao = new UserDaoImp();
		User user = new User(2,"������","123456","v",100,"654321","456789","123789");
		int i = dao.save(user);
		if(i>0){
			System.out.println("���ݱ���ɹ�");
		}else{
			System.out.println("���ݱ���ʧ��");
		}
	}

	

}
