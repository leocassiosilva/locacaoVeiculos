package br.com.spring.locacaoveiculos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

<<<<<<< HEAD
=======
	
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
	/* Para chamar o metodo da pagina inicial */
	@GetMapping("/home")
	public String home() {
		return "/home";
<<<<<<< HEAD
	}
=======
	}	
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
}
