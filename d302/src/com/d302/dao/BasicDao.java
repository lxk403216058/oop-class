package com.d302.dao;

import com.d302.entity.Page;

public interface BasicDao {
	//��ҳ
	Page paging(int pageNo,int pageSize);
}
