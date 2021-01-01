package br.com.spring.locacaoveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.VeiculoService;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping("/buscar")
	public ResponseEntity<Veiculo[]> veiculos() {

		Veiculo[] veiculo = veiculoService.buscarTodos();
		System.out.println("Deu certo");
		/// ModelAndView mv = new ModelAndView("veiculos").addObject("veiculos",
		/// veiculo);
		
		return ResponseEntity.ok(veiculo);
	}
}