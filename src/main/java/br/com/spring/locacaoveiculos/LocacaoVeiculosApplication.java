package br.com.spring.locacaoveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

<<<<<<< HEAD
=======
=======
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d

@SpringBootApplication
public class LocacaoVeiculosApplication {

<<<<<<< HEAD
	
=======
<<<<<<< HEAD
	
=======
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
	@Bean
	public WebClient webClientVeiculos(WebClient.Builder builder) {
		return builder.baseUrl("http://localhost:8081")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LocacaoVeiculosApplication.class, args);
	}

}
