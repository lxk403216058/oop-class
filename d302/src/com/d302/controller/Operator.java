package com.d302.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.d302.entity.Book;
import com.d302.service.BookService;
import com.d302.service.BookServiceImpl;
import com.d302.util.Input;


public class Operator {
	private static BookService service  = new BookServiceImpl();
	//�Ӽ��̻�ȡ�鱾��Ϣ������������ݿ�
	public static void saveBook(){
		//1.����һ����Ķ��󲢳�ʼ��������
		
		String title = Input.getString("�����������:","��������Ϊ�գ�����������:");
		String author = Input.getString("����:","������������Ϊ�գ�����������:");
		String pblisher = Input.getString("������:","���������Ʋ���Ϊ�գ�����������:");
		Date pub_date = Input.getDate("�����������:","�������ڲ���Ϊ�գ�����������:");
		float price = Input.getData("����۸�","�۸���Ϊ��");
		Book book = new Book(title,author,pblisher,pub_date,price);
		//2.���÷���㣬���䱣�浽���ݿ���
		int i = service.saveBook(book);
		if (i>0){
			System.out.println("�����Ϣ����ɹ���("+ service.findAll(book.getTitle()).get(0) +")");
		}else {
			System.out.println("�����Ϣ����ʧ�ܣ�");
		}
	}
	
	//��ȡ�����Ϣ
	public static void findById(){
		//1.����һ������ID
		int id = (int)Input.getData("����������ID:", "ID����Ϊ��:");
		//2.��ѯ��ID��Ϣ
		Book book = service.getBook(id);
		if (book != null) {
			System.out.println("��ѯ���"+service.getBook(id));
		} else {
			System.out.println("��ID:"+id+"���鲻����");
		}
		
		
	}
	
	//ɾ�������Ϣ
	public static void deteleBook(){
		//1.�Ӽ��̻��Ҫɾ�����鱾���
		Book book = null;
		int id = (int)Input.getData("�������ID", "��������ID����Ϊ����Ϊ����");
		//�жϴ˱�ŵ����Ƿ����
		book = service.getBook(id);
		
		//3.������,����÷����ɾ������
		if (book != null) {
			System.out.println(book);
			service.deleteBook(id);
			System.out.println("����idΪ��"+id+"�����Ѿ�ɾ��");
		} else {
			System.out.println("ɾ��ʧ�ܣ���ID:"+id+"���鲻����");
		}
		
	}
	
	//�޸������Ϣ
	public static void updateBook() {
		//1.�Ӽ��̻�ȡҪɾ�������ID
		int id  = Input.getInt("����Ҫ�������ID", "��������ID����Ϊ����Ϊ������");
		//2.��ѯ�˱�ŵ����Ƿ����
		Book book = service.getBook(id);
		if (book != null) {
			String title = Input.getString("��������(ԭ����"+ book.getTitle() +")", "��������Ϊ�գ�");
			
			book.setTitle(title);
			String author = Input.getString("�޸�����(ԭ����"+ book.getAuthor() +")", "����������Ϊ�գ�");
			
			book.setAuthor(author);
			String pblisher = Input.getString("���³�����(ԭ������"+ book.getPublisher() +")��", "�����粻��Ϊ��:");
			
			book.setPublisher(pblisher);
			Date pub_date = Input.getDate("�޸ĳ�������("+ book.getPub_date() +"):", "���ݸ�ʽ����:");
			
			book.setPub_date(pub_date);
			float price = Input.getData("������ļ۸�(ԭ�۸�"+ book.getPrice() +"):", "��������������һ����ֵ:");
			book.setPrice(price);
			int i = service.updateBook(book);
		if (i>0) {
			System.out.println("�����Ϣ���³ɹ���");
		} else {
			System.out.println("�����Ϣ����ʧ�ܣ�");
		}
		}else {
			System.out.println("����ʧ�ܣ���ID��"+id+" ���鲻����");
		}
		//3.�����ڣ��Ե�ǰ�����Ϣ���и���
		
		//4.���÷���㣬�����ºõ������ύ
		
	}
	
	//ģ����ѯ
	public static void findAll(){
		//1.�ȴӼ��̻��Ҫ��ѯ�Ĺؼ���
		List<Book> list= new ArrayList<Book>();
		
		String keyword = Input.getKeyword("�������ѯ�Ĺؼ���,��������������ո�Ͳ�ѯ����:");
		//2.���÷�����ѯ����
		list = service.findAll(keyword);
		//3.�ж����ݼ��Ĵ�С������ʾ
		int size = list.size();
		if (size>0) {
			System.out.println("�鵽��������:");
			for(Book b: list)
				System.out.println(b);
		} else {
			System.out.println("....û�в鵽������ݣ�");
		}
	}
	
	public static void main(String[] args) {
		//saveBook();
		//deteleBook();
		//updateBook();
		//findById();
		findAll();
	}

}
