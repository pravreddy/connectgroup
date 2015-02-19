package com.connectgroup.springmvc.bookstore.validators;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.connectgroup.springmvc.bookstore.forms.BookForm;

@Component
public class BookFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return BookForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	    BookForm form = (BookForm) target;
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", 
	    	"Please enter a valid value for BookName.");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishedDate",
	        "Please enter a valid value for Published Date.");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "copiesSold",
	        "Please enter a valid value for No of copies sold.");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pricePerCopy",
	        "Please enter a valid  value for Price per copy.");
	    String bookName = form.getBookName();
	    if (StringUtils.isNotBlank(bookName) && !StringUtils.isAlphanumeric(bookName)) {
	    	errors.rejectValue("bookName", "Please enter a Alpha Numaric  value for BookName.");
	    }

	    String publishedDate = form.getPublishedDate();	    
	    if(StringUtils.isNotBlank(publishedDate)) {
	    	if(!publishedDate.matches("\\d{4}-\\d{2}-\\d{2}"))
	    	{
	    		errors.rejectValue("publishedDate", "Please enter published date in yyyy-mm-dd format.");
	    	} 
	    	DateTime publishTime = DateTimeConverter.getDate(publishedDate);
	    	if(publishTime!=null&& publishTime.isAfterNow()){
	    		errors.rejectValue("publishedDate", "Please enter date less than today");
	    	}
	    	if(publishTime==null){
	    		errors.rejectValue("publishedDate", "Please enter valid Published Date value");
	    	}
	    }
	    
	    
	    String copiesSold = form.getCopiesSold();
	    if (StringUtils.isNotBlank(copiesSold) && !StringUtils.isNumeric(copiesSold)) {
	    	errors.rejectValue("copiesSold", "Please enter valid Integer value for  No of copies sold");
	    }
	    
	    String price = form.getPricePerCopy();
	    if (price != null && !price.matches("[0-9]+([.][0-9]{1,2})?")) {
	      errors.rejectValue("pricePerCopy", "Please enter valid value for Price per copy in 123.01 format");
	    }
		
	}
}
