package com.connectgroup.springmvc.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectgroup.springmvc.bookstore.dao.BookDao;
import com.connectgroup.springmvc.bookstore.domain.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired 
	private BookDao bookDao;
	
	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public List<Book> listBooks() {
		return bookDao.listBooks();
	}

}
