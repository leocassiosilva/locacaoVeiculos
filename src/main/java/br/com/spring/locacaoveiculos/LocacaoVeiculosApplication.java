package br.com.spring.locacaoveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class LocacaoVeiculosApplication {

	
	@Bean
	public WebClient webClientVeiculos(WebClient.Builder builder) {
		return builder.baseUrl("http://localhost:8081")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LocacaoVeiculosApplication.class, args);
	}

}
