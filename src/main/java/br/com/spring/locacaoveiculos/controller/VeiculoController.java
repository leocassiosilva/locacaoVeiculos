package br.com.spring.locacaoveiculos.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	/* Busca e lista os veiculos */
	@GetMapping("/buscar")
	public ModelAndView BuscarVeiculosDisponiveis(@RequestParam("dataRetirar") String dataRetirar,
			@RequestParam("dataDevolver") String dataDevolver, @RequestParam("nome") String nome, ModelMap model, 
			HttpSession session) {

		LocalDate localDate = LocalDate.parse(dataRetirar);
		LocalDate localDatee = LocalDate.parse(dataDevolver);

		Veiculo[] veiculo = veiculoService.buscarPorDatasAndNome(localDate, localDatee, nome);
		
		if (veiculo.length == 0) {
			return new ModelAndView("home").addObject("mensagem", "Não existe veiculos para as informações fornecidas!");
		}
		
		model.addAttribute("veiculos", veiculo);
		model.addAttribute("dataRetirar", dataRetirar);
		model.addAttribute("dataDevolver", dataDevolver);
		
		ModelAndView mv = new ModelAndView("veiculo/lista");


		return mv;
	}

	/* apresenta as informções do veiculo ao clicar no botão */
	@GetMapping("/{id}")
	public String infoVeiculos(@PathVariable("id") Long id, ModelMap model,
			@RequestParam("dataRetirar") String dataRetirar, @RequestParam("dataDevolver") String dataDevolver) {

		LocalDate localDate = LocalDate.parse(dataRetirar);
		LocalDate localDatee = LocalDate.parse(dataDevolver);

		Veiculo veiculo = veiculoService.buscarVeiculo(id);
		System.out.println("ID: " + id);
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

	/*
	 * @GetMapping("/locadora/{id}") public ResponseEntity<Optional<Locadora>>
	 * locadoraUnico(@PathVariable("id") Long id) { Optional<Locadora> locadora =
	 * locadoraService.buscarPorId(id); System.out.println("Deu certo"); return
	 * ResponseEntity.ok(locadora); }
	 */
}