package com.codeholic.eao.support;


/*
 * Page Number 从0开始计算，跟数组一个标准
 */

public class Pageable {
	private int pageSize;
	private int offset;
	private int pageNumber;
	
	private Pageable() {}

	private Pageable(int pageSize, int pageNumber) {
		this();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.offset = this.pageSize * this.pageNumber;
	}

	public static Pageable inPage(int pageNumber, int pageSize){
		return new Pageable(pageSize, pageNumber);
	}

	public int getPageNumber() {
		return pageNumber;
	}



	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
