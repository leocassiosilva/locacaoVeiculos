package br.com.spring.locacaoveiculos.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LocacaoveiculosController {

	

	/* Para chamar o metodo da pagina inicial */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "usuario/home";
	}	
	
}