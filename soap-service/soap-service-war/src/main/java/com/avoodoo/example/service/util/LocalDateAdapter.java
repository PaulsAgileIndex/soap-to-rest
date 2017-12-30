package com.avoodoo.example.service.util;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String dateString) throws Exception {
		LocalDate result = null;
		if (null != dateString) {
			result = LocalDate.parse(dateString, DateFormatUtils.DATE_FORMATTER);
		}
		return result;
	}

	@Override
	public String marshal(LocalDate date) throws Exception {
		String result = null;
		if (null != date) {
			result = DateFormatUtils.DATE_FORMATTER.format(date);
		}
		return result;
	}

}
