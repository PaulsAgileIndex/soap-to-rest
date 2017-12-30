package com.avoodoo.example.service.util;


/**
 * Utility class for date and time formatting. This provides a single location for date/time formats and thread-safe formatter objects that can be used when needed.
 * 
 * @author frank
 *
 */
public class DateFormatUtils {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_NO_DASH = "yyyyMdd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	public static final java.time.format.DateTimeFormatter DATE_FORMATTER = java.time.format.DateTimeFormatter.ofPattern(DATE_FORMAT);
	public static final java.time.format.DateTimeFormatter DATE_FORMATTER_NO_DASH = java.time.format.DateTimeFormatter.ofPattern(DATE_FORMAT_NO_DASH);
	public static final java.time.format.DateTimeFormatter DATE_TIME_FORMATTER = java.time.format.DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
	public static final org.joda.time.format.DateTimeFormatter JODA_DATE_FORMATTER = org.joda.time.format.DateTimeFormat.forPattern(DATE_FORMAT);
	public static final org.joda.time.format.DateTimeFormatter JODA_DATE_TIME_FORMATTER = org.joda.time.format.DateTimeFormat.forPattern(DATE_TIME_FORMAT);
	
	private DateFormatUtils() {}
}
