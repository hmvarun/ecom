package com.ecom.orderProcessService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {
	@Id
	@Column(name = "bookid")
	private String bookid;
	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private int price;
	@Column(name = "author")
	private String author;
	@Column(name = "category")
	private String category;

	/**
	 * @return the bookid
	 */
	public String getBookid() {
		return bookid;
	}

	/**
	 * @param bookid
	 *            the bookid to set
	 */
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

}
