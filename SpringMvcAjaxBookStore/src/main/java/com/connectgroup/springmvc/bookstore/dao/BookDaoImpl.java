package com.connectgroup.springmvc.bookstore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.connectgroup.springmvc.bookstore.domain.Book;

@Repository
public class BookDaoImpl implements BookDao {
	private List<Book> bookList = new ArrayList<Book>();

	@Override
	public void addBook(Book book) {
		bookList.add(book);		
	}

	@Override
	public List<Book> listBooks() {
		return bookList;
	} 

}
