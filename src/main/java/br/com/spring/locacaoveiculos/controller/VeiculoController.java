package br.com.spring.locacaoveiculos.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.LocadoraService;
import br.com.spring.locacaoveiculos.service.OpcionaisService;
import br.com.spring.locacaoveiculos.service.SeguroService;
import br.com.spring.locacaoveiculos.service.VeiculoService;
import br.com.spring.locacaoveiculos.model.Locadora;
import br.com.spring.locacaoveiculos.model.Opcionais;
import br.com.spring.locacaoveiculos.model.Seguro;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private SeguroService seguroService;
	
	@Autowired
	private LocadoraService locadoraService;
	
	@Autowired
	private OpcionaisService opcionaisService;
	

	@GetMapping("/buscar///")
	public ResponseEntity<Veiculo[]> veiculos() {

		Veiculo[] veiculo = veiculoService.buscarTodos();
		System.out.println("Deu certo");
		/// ModelAndView mv = new ModelAndView("veiculos").addObject("veiculos",
		/// veiculo);

		return ResponseEntity.ok(veiculo);
	}

	@GetMapping("/buscar")
	public String BuscarVeiculosDisponiveis(
			@RequestParam("dataRetirar") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataRetirar,
			@RequestParam("dataDevolver") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolver,
			@RequestParam("nome") String nome, ModelMap model) {
		System.out.println(nome);
		Veiculo[] veiculo = veiculoService.buscarPorDatasAndNome(dataRetirar, dataDevolver, nome);
		System.out.println("Deu certo");
		model.addAttribute("veiculos", veiculo);
		model.addAttribute("dataRetirar", dataRetirar);
		model.addAttribute("dataDevolver", dataDevolver);
		return "veiculo/lista";
	}

	@GetMapping("/{id}")
	public String infoVeiculos(@PathVariable("id") Long id, ModelMap model,
			@RequestParam("dataRetirar") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataRetirar,
			@RequestParam("dataDevolver") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolver) {
		Veiculo veiculo = veiculoService.buscarVeiculo(id);
		System.out.println(dataRetirar);
		model.addAttribute("veiculo", veiculo);
		model.addAttribute("dataRetirar", dataRetirar);
		model.addAttribute("dataDevolver", dataDevolver);
		return "veiculo/informacoes-veiculo";
	}
	
	@ModelAttribute("seguros")
	public void seguro(ModelMap model) {
		Seguro [] seguros = seguroService.buscarTodos();
		System.out.println("Deu ceeerto!");
		model.addAttribute("seguros", seguros);
	}
	
	@ModelAttribute("locadoras")
	public void locadora(ModelMap model) {
		Locadora [] locadoras = locadoraService.buscarTodos();
		model.addAttribute("locadoras", locadoras);
	}
	
	@ModelAttribute("opcionais")
	public void opcionais(ModelMap model) {
		Opcionais [] opcionais = opcionaisService.buscarTodosOpcionais();
		model.addAttribute("opcionais", opcionais);
	}
	
	/*
	@GetMapping("/opcional/{id}")
	public ResponseEntity<Optional<Opcionais>> opcionalUnico(@PathVariable("id") Long id) {

		Optional<Opcionais> opcionais = opcionaisService.buscarPorId(id);
		System.out.println("Deu certo");

		return ResponseEntity.ok(opcionais);
	}*/

}