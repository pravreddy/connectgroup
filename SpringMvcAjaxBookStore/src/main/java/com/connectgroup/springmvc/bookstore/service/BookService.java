package com.connectgroup.springmvc.bookstore.service;

import java.util.List;

import com.connectgroup.springmvc.bookstore.domain.Book;



public interface BookService {
	public void addBook(Book book);
	public List<Book> listBooks();
}
