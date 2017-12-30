package com.avoodoo.example.soaptorest.service.converter;

import java.time.LocalDate;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;


import com.avoodoo.example.server.utils.DateFormatUtils;
import com.avoodoo.example.soaptorest.model.constants.FscdConstants;

@Named
public class DatumSapConverter {
	
	public LocalDate convert(String dateString) {
		if (StringUtils.isEmpty(dateString) || FscdConstants.EMPTY_DATE_DASH.equals(dateString) || FscdConstants.EMPTY_DATE.equals(dateString)) {
			return null;
		}
		try {
			return LocalDate.parse(dateString, DateFormatUtils.DATE_FORMATTER);
		}
		catch (Exception e) {
			return LocalDate.parse(dateString, DateFormatUtils.DATE_FORMATTER_NO_DASH);
		}
	}
	
	public String convert(LocalDate date) {
		if (null == date) {
			return null;
		}
		return date.format(DateFormatUtils.DATE_FORMATTER);
	}

}
