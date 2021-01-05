package br.com.spring.locacaoveiculos.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.LocacaoService;

@Controller
@RequestMapping("/locacaos")
public class LocacaoController {

	@Autowired
	private LocacaoService locacaoService;

	@GetMapping(value = "/getLocacoesUsuarioEmail/{email}")
	public ResponseEntity<Locacao[]> listarLocacoesEmailUser(@PathVariable("email") String email) {
		System.out.println(email);
		Locacao[] locacao = locacaoService.buscarPeloUsuarioEmail(email);
		return ResponseEntity.ok(locacao);
	}

	@GetMapping(value = "/getLocacoesUsuario/{id}")
	public String listarLocacoesUsuario(@PathVariable("id") Long id, ModelMap model) {
		Locacao[] locacao = locacaoService.buscarPeloId(id);
		model.addAttribute("locacao", locacao);
		return "usuario/minhasLocacoes";
	}

	@PostMapping("/pagar")
	public String pagarLocacao (String dataRetirar, String dataDevolver, Veiculo veiculo, ModelMap model) {
		System.out.println(dataDevolver);
		// veiculoService.save(veiculo);
		return "/locacao/pagarLocacao";

	}

}