package com.hiper2d.serializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class JsonDateSerializer extends JsonSerializer<LocalDateTime> {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");;

	@Override
	public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		String formattedDate = formatter.format(date);
		gen.writeString(formattedDate);
	}

	
}
