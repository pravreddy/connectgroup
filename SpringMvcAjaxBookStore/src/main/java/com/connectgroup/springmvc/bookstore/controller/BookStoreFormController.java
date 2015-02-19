package com.connectgroup.springmvc.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.connectgroup.springmvc.bookstore.domain.Book;
import com.connectgroup.springmvc.bookstore.domain.JsonResponse;
import com.connectgroup.springmvc.bookstore.forms.BookForm;
import com.connectgroup.springmvc.bookstore.service.BookService;
import com.connectgroup.springmvc.bookstore.validators.BookFormValidator;
import com.connectgroup.springmvc.bookstore.validators.DateTimeConverter;


@Controller
@RequestMapping("/books")
public class BookStoreFormController {
	@Autowired
	private BookFormValidator formValidator;
	@Autowired
	private BookService bookService;
	
	@InitBinder("bookForm")
	public void initBookStoreFormBinder(WebDataBinder binder){
	    binder.setValidator(formValidator);
	    binder.setAllowedFields(new String[] { "bookName", "publishedDate", "copiesSold",
	        "pricePerCopy" });
	}
	  
	@ModelAttribute("bookForm")
	private BookForm populateBookForm() {
		  return new BookForm();
	}
	  
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String getBookForm() {
		  return "form";
	}
	  
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public @ResponseBody JsonResponse addBook(@ModelAttribute("bookForm") @Validated BookForm bookForm, 
			  BindingResult result) {
		  JsonResponse res = new JsonResponse();
		  if(result.hasErrors()){
			  res.setStatus("FAIL");
			  res.setResult(result.getAllErrors());
		  } else {
			  bookService.addBook(fillBook(bookForm));
			  res.setStatus("SUCCESS");
			  res.setResult(bookService.listBooks());			  
		  }		  
		  return res;
	}
	
	private Book fillBook(BookForm bookForm) {
		Book book = new Book();
		book.setBookName(bookForm.getBookName());
		book.setPublishedDate(DateTimeConverter.getDate(bookForm.getPublishedDate()));
		book.setCopiesSold(bookForm.getCopiesSold());
		book.setPricePerCopy(Float.valueOf(bookForm.getPricePerCopy()));
		return book;
	}
}
