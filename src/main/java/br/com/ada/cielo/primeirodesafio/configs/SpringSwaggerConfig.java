package br.com.ada.cielo.primeirodesafio.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringSwaggerConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {

		return new OpenAPI()//
				.info(new Info() //
						.title("aplicacao") //
						.description("descricao") //
						.version("versao 1.0")); //
	}
}