package com.hiper2d.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.hiper2d.serializer.DateSerializer;

@Component
public class StringDateParser {
	public LocalDate parseStringToLocalDate(String stringDate) {
		try {
			return LocalDate.parse(stringDate, DateSerializer.formatter_short);
		} catch (RuntimeException ex) {
			throw new IllegalArgumentException(
					"Provided parameter '" + stringDate + "' cannot be parsed to a Date. Please provide the parameter in 'yyyy-M-d' format");
		}
	}
}
