package com.d302.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.d302.entity.Book;
import com.d302.entity.Page;
import com.d302.util.DBUtil;


public class BookDaoImpl implements BookDao {

	@Override
	public int save(Book book) {
		int i=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into book(title,author,pblisher,pub_date,price)"+"values(?,?,?,?,?)";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setString(1, book.getTitle());//���ò���
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			long time  = book.getPub_date().getTime();//������ת��long��������
			pstmt.setDate(4,new java.sql.Date(time));//��long�������͹���java.sql.Date��������
			pstmt.setFloat(5, book.getPrice());
			
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
	public int delete(int id) {
		int i=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from book where id = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setInt(1, id);//���ò���
			
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
	public int update(Book book) {
		int i=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update book set title = ?,author = ?,pblisher = ?,pub_date = ?,price = ? where id = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setString(1, book.getTitle());//���ò���
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			long time  = book.getPub_date().getTime();//������ת��long��������
			pstmt.setDate(4,new java.sql.Date(time));//��long�������͹���java.sql.Date��������
			pstmt.setFloat(5, book.getPrice());
			pstmt.setInt(6, book.getId());
			
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
	public Book findById(int id) {
		Book book = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "select id,title,author,pblisher,pub_date,price from book where id = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setInt(1, id);//���ò���
			
			rs = pstmt.executeQuery();//ִ�в�ѯ
			while (rs.next()){//������ѯ�Ľ����
				String title = rs.getString(2);//rs.getString("title");
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				java.util.Date pub_date = rs.getDate(5);
				float price = rs.getFloat(6);
				
				book = new Book(id, title, author,publisher,pub_date,price);
			}
		}catch(Exception e){
			System.out.println("����id��ѯʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(rs,pstmt,conn);
		}
		
		return book;
	}

	@Override
	public List<Book> findAll(String keyword) {
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "select * from book "+
		" where title like ? or author like ? or pblisher like ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setString(1, "%"+keyword+ "%");//���ò���
			pstmt.setString(2, "%"+keyword+ "%");
			pstmt.setString(3, "%"+keyword+ "%");
			
			rs = pstmt.executeQuery();//ִ�в�ѯ
			while (rs.next()){//������ѯ�Ľ����
				int id  = rs.getInt(1);
				String title = rs.getString(2);//rs.getString("title");
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				java.util.Date pub_date = rs.getDate(5);
				float price = rs.getFloat(6);
				
				list.add(new Book(id, title, author,publisher,pub_date,price));
				}
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ģ����ѯʧ�ܣ�");
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,pstmt,conn);
		}
		
		return list;
	}
	/*
	public static void main(String[] args) {
		//saveBook();
		//deleteBook();
		//updateBook();
		//findBookById();
		findAllBook();
	}*/

	private static void findAllBook() {
		BookDao dao = new BookDaoImpl();
		List<Book> list = dao.findAll("��");
		
		Iterator<Book> it = list.iterator();
		while (it.hasNext()){
			Book book = it.next();
			System.out.println(book.toString());
		}
	}

	private static void findBookById() {
		BookDao dao = new BookDaoImpl();
		Book book = dao.findById(2);
		System.out.println(book.toString());
		
	}

	private static void updateBook() {
		BookDao dao = new BookDaoImpl();
		Book book = new Book(2,"�����Ӣ�۴���","������","���ӹ�ҵ������",new java.util.Date(),34.56F);
		int i = dao.update(book);
		if(i>0){
			System.out.println("�����޸ĳɹ�");
		}else{
			System.out.println("�����޸�ʧ��");
		}
	}

	private static void deleteBook() {
		BookDao dao = new BookDaoImpl();
		int i = -1;
		i = dao.delete(1);
		if(i>0){
			System.out.println("����ɾ���ɹ�");
		}else{
			System.out.println("����ɾ��ʧ��"); 
		}
	}

	private static void saveBook() {
		BookDao dao = new BookDaoImpl();
		Book book = new Book("�����������ǡ�","��ӹ","��е��ҵ������",new java.util.Date(),45.56F);
		int i = dao.save(book);
		if(i>0){
			System.out.println("���ݱ���ɹ�");
		}else{
			System.out.println("���ݱ���ʧ��");
		}
	}
	
	@Override
	public Page paging(int pageNo,int pageSize){
		BookDao dao = new BookDaoImpl();
		//��ѯ��������
		List<Book> list = dao.findAll("");
		Page page = new Page(list.size(), pageSize);
		page.setPageNo(pageNo);
		page.setData(list);
		
		return page;
	}
	
	//�Է�ҳ�ķ�ʽ��ȡ����
		public static List<Book> getListData(int pageNo,int pageSize){
			List<Book> list = new ArrayList<Book>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet  rs = null;
			String sql = "select * from book limit" + ((pageNo-1)*pageSize)+ ","+ pageNo*pageSize;
			System.out.println("sql----->"+sql);
			try {
				conn = DBUtil.getConnection();//��ȡ����
				pstmt = conn.prepareStatement(sql);//�õ�����
				
				rs = pstmt.executeQuery();//ִ�в�ѯ
				while (rs.next()){//������ѯ�Ľ����
					int id  = rs.getInt(1);
					String title = rs.getString(2);//rs.getString("title");
					String author = rs.getString(3);
					String publisher = rs.getString(4);
					java.util.Date pub_date = rs.getDate(5);
					float price = rs.getFloat(6);
					
					list.add(new Book(id, title, author,publisher,pub_date,price));
					}
					
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("ģ����ѯʧ�ܣ�");
				e.printStackTrace();
			}finally{
				DBUtil.close(rs,pstmt,conn);
			}
			
			return list;
		}

}
