package com.d302.dao;

import java.util.List;
import com.d302.entity.Book;
import com.d302.entity.Page;

public interface BookDao extends BasicDao {
	//��������control,shift+o
	int save(Book book);
	//ɾ������
	int delete(int id);
	//�޸�����
	int update(Book book);
	//��ѯһ����
	Book findById(int id);
	//��ѯ�౾��
	List<Book> findAll(String keyword);
	
	//��ҳ
	Page paging(int pageNo,int pageSize);
}
