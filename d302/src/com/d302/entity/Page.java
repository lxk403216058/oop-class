package com.d302.entity;

import java.util.List;

public class Page {
	private List data ;//����
	private int pageNo;//��ǰҳ��
	private int totalPage;//�ܵ�ҳ��
	private int pageSize;//ÿҳ��ʾ������
	private int totalCount;//�ܵļ�¼����
	
	public Page(int totalCount,int pageSize){
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		
		//����ܼ�¼��������ÿҳ��ʾ�������������򲻱䣬�����һ
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
