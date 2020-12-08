package com.d302.service;

import java.util.List;
import com.d302.entity.Book;
import com.d302.entity.Page;

public interface BookService {
	//存书的方法
	public abstract int saveBook(Book book);
	
	//删除书本
	int deleteBook(int id);
	
	//根据id更新一本书的信息
	int updateBook(Book book);
	
	//查询一本书的信息
	Book getBook(int id);
	
	//根据传入关键字模糊查询书籍
	List<Book> findAll(String keyword);
	
	//分页
	Page paging(int pageNo,int pageSize);
	
}
