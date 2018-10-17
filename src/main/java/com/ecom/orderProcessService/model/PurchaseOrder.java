package com.ecom.orderProcessService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PO")
public class PurchaseOrder {
	@Id
	@Column(name = "purchase_id")
	private String purchase_id;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private AccountInfo account;

	@Column(name = "shipping_info")
	private String shipping_info;

	@Column(name = "total_price")
	private int total_price;

	@Column(name = "status")
	private String status;

	public String getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}

	public AccountInfo getAccount() {
		return account;
	}

	public void setAccount(AccountInfo account) {
		this.account = account;
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

	public void setTotal_price(int i) {
		this.total_price = i;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
