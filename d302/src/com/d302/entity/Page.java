package com.d302.entity;

import java.util.List;

public class Page {
	private List data ;//数据
	private int pageNo;//当前页码
	private int totalPage;//总的页数
	private int pageSize;//每页显示的条数
	private int totalCount;//总的记录条数
	
	public Page(int totalCount,int pageSize){
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		
		//如果总记录条数除以每页显示的条数等于零则不变，否则加一
		if (totalCount%pageSize == 0){
			this.totalPage =  totalCount/pageSize;
		}else {
			this.totalPage =  totalCount/pageSize+1;
		}
		
	}
	
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
}
