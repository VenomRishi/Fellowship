package com.bridgelabz.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {
	private String shopName;
	private List<Book> books = new ArrayList<>();

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void loadData() {
		for (int i = 1; i <= 10; i++) {
			Book b = new Book();
			b.setBid(i);
			b.setBname("book" + i);
			getBooks().add(b);
		}
	}

	@Override
	public String toString() {
		return "BookShop [shopName=" + shopName + ", books=" + books + "]";
	}

	// this method using shallow clonning
	// if we remove one object from book list we are getting removed data in object
	// 2nd
	// to come up with this problem we are going to use deep clonning
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		// TODO Auto-generated method stub
//		return super.clone();
//	}

	@Override
	protected BookShop clone() throws CloneNotSupportedException {
		BookShop bs = new BookShop();
		for (Book book : this.getBooks()) {
			bs.getBooks().add(book);
		}
		return bs;
	}

}
