package com.ecom.orderProcessService.response;

import java.util.List;

import com.ecom.orderProcessService.model.Book;

public class OrderProcessServiceResponse {

	private String status;

	private int httpCode;

	private List<Book> books;

	private List<String> values;

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
