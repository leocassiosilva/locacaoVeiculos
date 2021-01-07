package br.com.spring.locacaoveiculos.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String BuscarVeiculosDisponiveis(@RequestParam("dataRetirar") String dataRetirar,
			@RequestParam("dataDevolver") String dataDevolver, @RequestParam("nome") String nome, ModelMap model) {

		LocalDate localDate = LocalDate.parse(dataRetirar);
		LocalDate localDatee = LocalDate.parse(dataDevolver);

		Veiculo[] veiculo = veiculoService.buscarPorDatasAndNome(localDate, localDatee, nome);
		model.addAttribute("veiculos", veiculo);
		model.addAttribute("dataRetirar", dataRetirar);
		model.addAttribute("dataDevolver", dataDevolver);
		return "veiculo/lista";
	}

	@GetMapping("/{id}")
	public String infoVeiculos(@PathVariable("id") Long id, ModelMap model,
			@RequestParam("dataRetirar") String dataRetirar, @RequestParam("dataDevolver") String dataDevolver) {

		LocalDate localDate = LocalDate.parse(dataRetirar);
		LocalDate localDatee = LocalDate.parse(dataDevolver);
		
		Veiculo veiculo = veiculoService.buscarVeiculo(id);
		model.addAttribute("veiculo", veiculo);
		model.addAttribute("dataRetirar", localDate);
		model.addAttribute("dataDevolver", localDatee);
		return "veiculo/informacoes-veiculo";
	}

	@ModelAttribute("seguros")
	public void seguro(ModelMap model) {
		Seguro[] seguros = seguroService.buscarTodos();
		model.addAttribute("seguros", seguros);
	}

	@ModelAttribute("locadoras")
	public void locadora(ModelMap model) {
		Locadora[] locadoras = locadoraService.buscarTodos();
		model.addAttribute("locadoras", locadoras);
	}

	@ModelAttribute("opcionais")
	public void opcionais(ModelMap model) {
		Opcionais[] opcionais = opcionaisService.buscarTodosOpcionais();
		model.addAttribute("opcionais", opcionais);
	}

}