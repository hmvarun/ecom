package com.ecom.orderProcessService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POITEM")
public class POItem {

	@Id
	@Column(name = "Id")
	private String id;

	@ManyToOne
	@JoinColumn(name = "bookid")
	private Book bookid;

	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private PurchaseOrder purchase_id;

	public Book getBook() {
		return bookid;
	}

	public void setBookid(Book book) {
		this.bookid = book;
	}

	public PurchaseOrder getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(PurchaseOrder purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
