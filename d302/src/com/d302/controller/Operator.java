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
	//从键盘获取书本信息并将其存入数据库
	public static void saveBook(){
		//1.创建一本书的对象并初始化其属性
		
		String title = Input.getString("输入书的名称:","书名不能为空，请重新输入:");
		String author = Input.getString("作者:","作者姓名不能为空，请重新输入:");
		String pblisher = Input.getString("出版社:","出版社名称不能为空，请重新输入:");
		Date pub_date = Input.getDate("输入出版日期:","出版日期不能为空，请重新输入:");
		float price = Input.getData("输入价格","价格不能为空");
		Book book = new Book(title,author,pblisher,pub_date,price);
		//2.调用服务层，将其保存到数据库中
		int i = service.saveBook(book);
		if (i>0){
			System.out.println("书的信息保存成功！("+ service.findAll(book.getTitle()).get(0) +")");
		}else {
			System.out.println("书的信息保存失败！");
		}
	}
	
	//获取书的信息
	public static void findById(){
		//1.输入一个整形ID
		int id = (int)Input.getData("输入待查书的ID:", "ID不能为空:");
		//2.查询此ID信息
		Book book = service.getBook(id);
		if (book != null) {
			System.out.println("查询结果"+service.getBook(id));
		} else {
			System.out.println("此ID:"+id+"的书不存在");
		}
		
		
	}
	
	//删除书的信息
	public static void deteleBook(){
		//1.从键盘获得要删除的书本编号
		Book book = null;
		int id = (int)Input.getData("输入书的ID", "输入有误ID不能为空且为整数");
		//判断此编号的书是否存在
		book = service.getBook(id);
		
		//3.若存在,则调用服务层删除数据
		if (book != null) {
			System.out.println(book);
			service.deleteBook(id);
			System.out.println("上述id为："+id+"的书已经删除");
		} else {
			System.out.println("删除失败！此ID:"+id+"的书不存在");
		}
		
	}
	
	//修改书的信息
	public static void updateBook() {
		//1.从键盘获取要删除的书的ID
		int id  = Input.getInt("输入要更新书的ID", "输入有误ID不能为空且为正整数");
		//2.查询此编号的书是否存在
		Book book = service.getBook(id);
		if (book != null) {
			String title = Input.getString("更新书名(原书名"+ book.getTitle() +")", "书名不能为空：");
			
			book.setTitle(title);
			String author = Input.getString("修改作者(原作者"+ book.getAuthor() +")", "作者名不能为空：");
			
			book.setAuthor(author);
			String pblisher = Input.getString("更新出版社(原出版社"+ book.getPublisher() +")：", "出版社不能为空:");
			
			book.setPublisher(pblisher);
			Date pub_date = Input.getDate("修改出版日期("+ book.getPub_date() +"):", "数据格式错误:");
			
			book.setPub_date(pub_date);
			float price = Input.getData("更新书的价格(原价格"+ book.getPrice() +"):", "输入有误，请输入一个数值:");
			book.setPrice(price);
			int i = service.updateBook(book);
		if (i>0) {
			System.out.println("书的信息更新成功！");
		} else {
			System.out.println("书的信息更新失败！");
		}
		}else {
			System.out.println("更新失败！此ID："+id+" 的书不存在");
		}
		//3.若存在，对当前书的信息进行更新
		
		//4.调用服务层，将更新好的数据提交
		
	}
	
	//模糊查询
	public static void findAll(){
		//1.先从键盘获得要查询的关键字
		List<Book> list= new ArrayList<Book>();
		
		String keyword = Input.getKeyword("请输入查询的关键字,如果不输入或输入空格就查询所有:");
		//2.调用服务层查询数据
		list = service.findAll(keyword);
		//3.判断数据集的大小进行显示
		int size = list.size();
		if (size>0) {
			System.out.println("查到以下数据:");
			for(Book b: list)
				System.out.println(b);
		} else {
			System.out.println("....没有查到相关数据！");
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
