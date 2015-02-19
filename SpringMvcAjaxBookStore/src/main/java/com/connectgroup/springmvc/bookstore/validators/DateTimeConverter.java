package com.connectgroup.springmvc.bookstore.validators;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateTimeConverter
{
	private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
	
	
	public static DateTime getDate(String source) {
		return convert(source);
	}
	
	public static String toString(DateTime source){
		DateTimeFormatter formatter = DateTimeFormat.forPattern(DEFAULT_PATTERN);;
		return formatter.print(source);
	}
	
	private static  DateTime convert(String source) {
		DateTimeFormatter formatter;
		DateTime date=null;
		if (source == null || StringUtils.isEmpty(source)){
		  return null;
		}
		try {
			formatter = DateTimeFormat.forPattern(DEFAULT_PATTERN);
			date=formatter.parseDateTime(source);
		} catch(Exception e) {
			return date;
		}
		
		return date;
	}

}
