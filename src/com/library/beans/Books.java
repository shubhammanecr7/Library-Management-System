package com.library.beans;

//This class represents the properties of a book
public class Books {
	private String bid, name, author, publisher;
	private int quantity, issued;

	public Books() {
	}

	public Books(String bid, String name, String author, String publisher, int quantity) {
		super();
		this.bid = bid;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity >= 0) {
			this.quantity = quantity;
		} else {
			this.quantity = 0;
		}
	}

	public int getIssued() {
		return issued;
	}

	public void setIssued(int issued) {
		this.issued = issued;
	}

	@Override
	public String toString() {
		return "Books{" + "bid='" + bid + '\'' + ", name='" + name + '\'' + ", author='" + author + '\''
				+ ", publisher='" + publisher + '\'' + ", quantity=" + quantity + ", issued=" + issued + '}';
	}

}
