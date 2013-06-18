package com.example.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * 
 * @author anirudh
 *
 */
public class CommonUtils {
	
	private final static String DATE_FORMAT = "dd/MM/yyyy";
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	
	public static Date getFormattedDate(String date) throws ParseException {
		return sdf.parse(date);
	}

	
	public static String getFormattedStringFromDate(Date date){
		return sdf.format(date);
	}
	
	public static Date removeTimeFromDate(Date date){
		return DateUtils.truncate(date, Calendar.DATE);
	}
	
	public static int isDateSame(Date date1, Date date2) throws ParseException{
		Date date1WithoutTime = DateUtils.truncate(date1, Calendar.DATE);
		Date date2WithoutTime = DateUtils.truncate(date2, Calendar.DATE);
		return date1WithoutTime.compareTo(date2WithoutTime);
		
	}
	
	
	public static Date getFormattedDateWithoutTime(String date) throws ParseException{
		return removeTimeFromDate(getFormattedDate(date));
	}
}
