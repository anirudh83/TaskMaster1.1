package com.example.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author anirudh
 *
 */
public class CommonUtils {
	
	private final static String DATE_FORMAT = "dd/mm/yyyy";
	
	public static Date getFormattedDate(String date) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date formattedDate = sdf.parse(date);
		return formattedDate;
	}

	
	public static String getFormattedStringFromDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
	}
	
}
