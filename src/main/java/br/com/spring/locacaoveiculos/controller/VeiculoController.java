package br.com.spring.locacaoveiculos.controller;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

<<<<<<< HEAD
=======
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.VeiculoService;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

<<<<<<< HEAD
	@GetMapping("/buscar///")
=======
<<<<<<< HEAD
	@GetMapping("/buscar///")
=======
	@GetMapping("/buscar")
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
	public ResponseEntity<Veiculo[]> veiculos() {

		Veiculo[] veiculo = veiculoService.buscarTodos();
		System.out.println("Deu certo");
		/// ModelAndView mv = new ModelAndView("veiculos").addObject("veiculos",
		/// veiculo);
		
		return ResponseEntity.ok(veiculo);
	}
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
	
	@GetMapping("/buscar")
	public String BuscarVeiculosDisponiveis(@RequestParam("dataRetirar") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataRetirar,
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
<<<<<<< HEAD
=======
=======
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
}