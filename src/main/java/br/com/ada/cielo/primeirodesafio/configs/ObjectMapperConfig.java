package br.com.ada.cielo.primeirodesafio.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class ObjectMapperConfig {

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
	    mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		return mapper;
	}
}
