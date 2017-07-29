package com.hiper2d.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.text.SimpleDateFormat;

import com.hiper2d.serializer.DateSerializerModule;
import com.hiper2d.serializer.DateSerializer;
import com.hiper2d.util.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@Import({JpaConfig.class})
@ComponentScan(basePackages = {Packages.SERVICES})
public class SpringConfig {
	
	@Bean
	public ObjectMapper jacksonObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.registerModule(new DateSerializerModule());
	    return mapper;
	}
}
