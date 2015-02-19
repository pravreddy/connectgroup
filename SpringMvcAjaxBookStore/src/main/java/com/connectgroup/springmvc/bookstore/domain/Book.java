package com.connectgroup.springmvc.bookstore.domain;

import org.joda.time.DateTime;

public class Book {
	
	private String bookName;
	private DateTime publishedDate;
	private String copiesSold;
	private Float pricePerCopy;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public DateTime getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(DateTime publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getCopiesSold() {
		return copiesSold;
	}
	public void setCopiesSold(String copiesSold) {
		this.copiesSold = copiesSold;
	}
	public Float getPricePerCopy() {
		return pricePerCopy;
	}
	public void setPricePerCopy(Float pricePerCopy) {
		this.pricePerCopy = pricePerCopy;
	}	
}
