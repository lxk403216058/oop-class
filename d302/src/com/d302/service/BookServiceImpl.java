package com.d302.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.d302.dao.BookDao;
import com.d302.dao.BookDaoImpl;
import com.d302.entity.Book;
import com.d302.entity.Page;
import com.d302.util.DBUtil;

public class BookServiceImpl implements BookService {
	private BookDao dao;
	
	
	
	public BookServiceImpl() {
		this.dao = new BookDaoImpl();
	}
	
	@Override
	public int saveBook(Book book) {
		if (book !=null){
			String title = book.getTitle();
			if (title.contains("自杀")){
				title = title.replace("自杀", "**");
				book.setTitle(title);
			}
			return dao.save(book);
		}
		return -1;
	}
	
	@Override
	public int deleteBook(int id){
		
		Book book = dao.findById(id);
		if(book != null){
			return this.dao.delete(id);
		}
		
		return -1;
	}
	
	@Override
	public Book getBook(int id){
		return dao.findById(id);
	}
	
	@Override
	public int updateBook(Book book){
		Book b = this.dao.findById(book.getId());
		if (b != null){
			return this.dao.update(book);
		}
		return -1;
	}
	
	@Override
	public List<Book> findAll(String keyword){
		List<Book> list = null;
		
		if (keyword == null || "".equals(keyword.trim())){
			keyword = "";
		}
		
		return this.dao.findAll(keyword);
	}
	
	public static void main(String[] args) {
		//idGetBook();
		//keywordFindAll();
		//idDeleteBook();
		//bookUpdateBook();
		//bookSaveBook();
		BookService service = new BookServiceImpl();
		Page page = service.paging(1, 3);
		System.out.println("总共有"+page.getTotalPage()+"");
	}
	
	private static void bookSaveBook() {
		BookService service = new BookServiceImpl();
		Book book = new Book(3,"《射雕英雄传》","金庸","上海三联出版社",new java.util.Date(),10.11F);
		service.saveBook(book);
	}

	private static void bookUpdateBook() {
		BookService service = new BookServiceImpl();
		Book book = new Book(3,"《射雕英雄传》","金庸","上海三联出版社",new java.util.Date(),10.11F);
		service.updateBook(book);
	}

	private static void idDeleteBook() {
		BookService service = new BookServiceImpl();
		service.deleteBook(2);
	}

	private static void keywordFindAll() {
		BookService service = new BookServiceImpl();
		List<Book> list= new ArrayList<Book>();
		list = service.findAll(null);
		Iterator<Book> it = list.iterator();
		while (it.hasNext()){
			Book book = it.next();
			System.out.println(book.toString());
		}
	}

	private static void idGetBook() {
		BookService service = new BookServiceImpl();
		Book book = service.getBook(3);
		System.out.println(book);
	}

	@Override
	public Page paging(int pageNo, int pageSize) {
		
		return dao.paging(pageNo, pageSize);
	}
	

}
