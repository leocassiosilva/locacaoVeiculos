package br.com.spring.locacaoveiculos.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.spring.locacaoveiculos.service.VeiculoService;


@Controller
@RequestMapping("locacao")
public class LocacaoveiculosController {

	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/veiculo/{id}")
	public String preLocacao(@PathVariable("id") Long id, ModelMap model) {
		System.out.println(id);
		veiculoService.buscarPeloId(id);
		return "/locacao/cadastroLocacao";

	}
	
}