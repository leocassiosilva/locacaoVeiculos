package br.com.spring.locacaoveiculos.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("locacao")
public class LocacaoveiculosController {

	
	@GetMapping("/veiculo/{id}")
	public String preLocacao(@PathVariable("id") Long id, ModelMap model) {
		System.out.println(id);
		return "/locacao/cadastroLocacao";

	}
	
}