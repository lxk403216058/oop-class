package com.d302.dao;

import java.util.List;
import com.d302.entity.Book;
import com.d302.entity.Page;

public interface BookDao extends BasicDao {
	//增加数据control,shift+o
	int save(Book book);
	//删除数据
	int delete(int id);
	//修改数据
	int update(Book book);
	//查询一本书
	Book findById(int id);
	//查询多本书
	List<Book> findAll(String keyword);
	
	//分页
	Page paging(int pageNo,int pageSize);
}
