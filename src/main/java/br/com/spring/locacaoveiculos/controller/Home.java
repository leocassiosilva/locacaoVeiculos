package br.com.spring.locacaoveiculos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	
	/* Para chamar o metodo da pagina inicial */
	@GetMapping("/home")
	public String home() {
		return "/home";
	}	
}
