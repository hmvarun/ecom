package com.ecom.orderProcessService.request;

import java.util.List;

public class OrderRequest {

	private String accountId;
	private String shipping_info;
	private int total_price;
	private String status;
	private List<String> bookIds;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getShipping_info() {
		return shipping_info;
	}

	public void setShipping_info(String shipping_info) {
		this.shipping_info = shipping_info;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getBookIds() {
		return bookIds;
	}

	public void setBookIds(List<String> bookIds) {
		this.bookIds = bookIds;
	}

}
