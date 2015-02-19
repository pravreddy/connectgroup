package com.connectgroup.springmvc.bookstore.dao;

import java.util.List;

import com.connectgroup.springmvc.bookstore.domain.Book;


public interface BookDao {
	public void addBook(Book book);
	public List<Book> listBooks();
}
