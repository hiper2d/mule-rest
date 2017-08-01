package com.hiper2d.serializer;

import java.io.IOException;
import java.time.LocalDateTime;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class DateDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		return LocalDateTime.parse(jsonparser.getText(), DateSerializer.formatter);
	}

}
