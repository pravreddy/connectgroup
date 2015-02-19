package com.connectgroup.springmvc.bookstore.forms;


/*
 * This is a Form Backing Bean for Book Domain Object
 */
public class BookForm {
	
	private String bookName;
	private String publishedDate;
	private String copiesSold;
	private String pricePerCopy;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getCopiesSold() {
		return copiesSold;
	}
	public void setCopiesSold(String copiesSold) {
		this.copiesSold = copiesSold;
	}
	public String getPricePerCopy() {
		return pricePerCopy;
	}
	public void setPricePerCopy(String pricePerCopy) {
		this.pricePerCopy = pricePerCopy;
	}
}
