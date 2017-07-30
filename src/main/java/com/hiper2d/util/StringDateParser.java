package com.hiper2d.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.hiper2d.serializer.DateSerializer;

@Component
public class StringDateParser {
	public boolean validateString(String stringDate) throws Exception {
		try {
			parseStringToLocalDate(stringDate);
		} catch (RuntimeException ex) {
			// todo: should be replaced with normal error handling on Mule side
			return false;
		}
		return true;
	}
	
	public LocalDate parseStringToLocalDate(String stringDate) {
		return LocalDate.parse(stringDate, DateSerializer.formatter_short);
	}
}
