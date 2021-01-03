package br.com.spring.locacaoveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.service.LocacaoService;

@Controller
<<<<<<< HEAD
@RequestMapping("/locacaos")
=======
<<<<<<< HEAD
@RequestMapping("/locacaos")
=======
@RequestMapping("locacaos")
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
public class LocacaoController {

	@Autowired
	private LocacaoService locacaoService;

	@GetMapping(value = "/getLocacoesUsuarioEmail/{email}")
	public ResponseEntity<Locacao[]> listarLocacoesEmailUser(@PathVariable("email") String email) {
<<<<<<< HEAD
		System.out.println(email);
=======
<<<<<<< HEAD
		System.out.println(email);
=======
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
		Locacao[] locacao = locacaoService.buscarPeloUsuarioEmail(email);
		return ResponseEntity.ok(locacao);
	}

	@GetMapping(value = "/getLocacoesUsuario/{id}")
	public String listarLocacoesUsuario(@PathVariable("id") Long id, ModelMap model) {
		Locacao[] locacao = locacaoService.buscarPeloId(id);
		model.addAttribute("locacao", locacao);
		return "usuario/minhasLocacoes";
	}
}