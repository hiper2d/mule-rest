package com.hiper2d.serializer;

import java.time.LocalDateTime;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;

public class DateSerializerModule extends SimpleModule {

	public DateSerializerModule() {
		super("DateSerializerModule", new Version(1, 0, 0, "SNAPSHOT"));
	    addSerializer(LocalDateTime.class, new JsonDateSerializer());
	}
}