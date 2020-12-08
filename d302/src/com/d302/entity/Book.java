package com.d302.entity;

import java.util.Date;

public class Book {
	//属性
	private int id;
	private String title;
	private String author;
	private String publisher;
	private java.util.Date pub_date;
	private float price;
	
	//无参构造
	public Book(){
		
	}
	
	//有参构造1（全部参数）
	
	
	//有参构造2（不含id）
	public Book(String author, String publisher, Date pub_date, float price) {
		super();
		this.author = author;
		this.publisher = publisher;
		this.pub_date = pub_date;
		this.price = price;
	}

	public Book(int id, String title, String author, String publisher, Date pub_date, float price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pub_date = pub_date;
		this.price = price;
	}

	public Book(String title, String author, String publisher, Date pub_date, float price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pub_date = pub_date;
		this.price = price;
	}

	//set和get方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public java.util.Date getPub_date() {
		return pub_date;
	}

	public void setPub_date(java.util.Date pub_date) {
		this.pub_date = pub_date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", pub_date="
				+ pub_date + ", price=" + price + "]";
	}

	
	
	
	
	

}
