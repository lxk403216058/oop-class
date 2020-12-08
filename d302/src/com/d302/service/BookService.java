package com.d302.service;

import java.util.List;
import com.d302.entity.Book;
import com.d302.entity.Page;

public interface BookService {
	//����ķ���
	public abstract int saveBook(Book book);
	
	//ɾ���鱾
	int deleteBook(int id);
	
	//����id����һ�������Ϣ
	int updateBook(Book book);
	
	//��ѯһ�������Ϣ
	Book getBook(int id);
	
	//���ݴ���ؼ���ģ����ѯ�鼮
	List<Book> findAll(String keyword);
	
	//��ҳ
	Page paging(int pageNo,int pageSize);
	
}
