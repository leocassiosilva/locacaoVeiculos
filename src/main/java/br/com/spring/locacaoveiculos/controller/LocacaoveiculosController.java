package br.com.spring.locacaoveiculos.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.spring.locacaoveiculos.model.Local;
import br.com.spring.locacaoveiculos.model.Seguro;
import br.com.spring.locacaoveiculos.service.LocalService;
import br.com.spring.locacaoveiculos.service.SeguroService;
import br.com.spring.locacaoveiculos.service.VeiculoService;


@Controller
@RequestMapping("locacao")
public class LocacaoveiculosController {

	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private SeguroService seguroService;
	
	@Autowired
	private LocalService localService;
	
	
	@GetMapping("/veiculo/{id}")
	public String preLocacao(@PathVariable("id") Long id, ModelMap model) {
		System.out.println(id);
		model.addAttribute("veiculo", veiculoService.buscarVeiculo(id)); 
		System.out.println(veiculoService.buscarVeiculo(id));
		return "/locacao/cadastroLocacao";

	}
	
	@ModelAttribute("seguros")
	public List<Seguro> listaSeguros() {
		return seguroService.buscarTodos();
	}
	
	@ModelAttribute("locais")
	public List<Local> listaLocais() {
		return localService.buscarTodos();
	}
	
	
	@PostMapping("/pagar")
	public String pagarLocacao() {
		System.out.println("Pague a locação rapaz!");
		return "/locacao/pagarLocacao";

	}
	
}