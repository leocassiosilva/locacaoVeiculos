package br.com.spring.locacaoveiculos.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.model.Locadora;
import br.com.spring.locacaoveiculos.model.Opcionais;
import br.com.spring.locacaoveiculos.model.Seguro;
import br.com.spring.locacaoveiculos.model.Usuario;
import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.LocacaoService;
import br.com.spring.locacaoveiculos.service.LocadoraService;
import br.com.spring.locacaoveiculos.service.OpcionaisService;
import br.com.spring.locacaoveiculos.service.SeguroService;
import br.com.spring.locacaoveiculos.service.VeiculoService;

@Controller
@RequestMapping("/locacaos")
public class LocacaoController {

	@Autowired
	private LocacaoService locacaoService;

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private SeguroService seguroService;

	@Autowired
	private OpcionaisService optionalService;
	
	
	@Autowired
	private LocadoraService locadoraService;

	@GetMapping(value = "/getLocacoesUsuarioEmail/{email}")
	public ResponseEntity<Locacao[]> listarLocacoesEmailUser(@PathVariable("email") String email) {
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
	public String pagarLocacao(ModelMap model, String dataRetirar, String dataDevolver, String seguro,
			String locadoraDevolucao, String opcional, String veiculo,  HttpSession session) {
		
		
		Long usuarioLogado =  (Long) session.getAttribute("id_usuario");
		
		if(usuarioLogado == null) {
			return "redirect:login";
		}
		// veiculoService.save(veiculo);

		LocalDate localDate = LocalDate.parse(dataRetirar);
		LocalDate localDatee = LocalDate.parse(dataDevolver);
		/* Serve para calcular quantidade de dias entre datas */
		long diaria = ChronoUnit.DAYS.between(localDate, localDatee);
		long v = Long.parseLong(veiculo);
		long s = Long.parseLong(seguro);
		long o = Long.parseLong(opcional);
		long l = Long.parseLong(locadoraDevolucao);
		
		System.out.println("Opcionais = "  + opcional);
		
		Seguro seg = seguroService.buscarPorId(s);

		Veiculo veic = veiculoService.buscarVeiculo(v);

		System.out.println(o);
		model.addAttribute("veiculo", veic);
		model.addAttribute("opcional", opcional);

		
		
		double valorSeguro = (seg.getPreco() * diaria);
		double valorLocacao = (veic.getCategoria().getValor() * diaria);
		double valorTotal = (valorLocacao + valorSeguro);

		System.out.println("Diaria: " + diaria);
		System.out.println("Valor veiculo: " + veic.getCategoria().getValor());
		
		Locadora locadora = locadoraService.buscarPorId(l);
		
		
  		model.addAttribute("locadoraDevolucao", locadora);
		model.addAttribute("diarias", diaria);
		model.addAttribute("valorLocacao", valorLocacao);
		model.addAttribute("valorTotal", valorTotal);
		model.addAttribute("seguro", valorSeguro);
		model.addAttribute("dataRetirar", localDate);
		model.addAttribute("dataDevolver", localDatee);
		model.addAttribute("seg", seg.getId_seguro());
		
		return "/locacao/pagarLocacao";

	}
	
	@PostMapping("/salvar")
	public String confirmarPagamento(String dataRetirar, String dataDevolver, String id_seguro,
			String locadoraDevolucao, String opcional, String id_veiculo, double valorTotal, Locacao locacao) {
		System.out.println(valorTotal);
		
		LocalDate localDate = LocalDate.parse(dataRetirar);
		LocalDate localDatee = LocalDate.parse(dataDevolver);
		
		

		System.out.println(localDate);
		System.out.println(opcional);
		System.out.println(id_seguro);
		System.out.println(locadoraDevolucao);
		
		
		long v = Long.parseLong(id_veiculo);
		long s = Long.parseLong(id_seguro);
		long o = Long.parseLong(opcional);
		long l = Long.parseLong(locadoraDevolucao);
		
		Seguro seg = seguroService.buscarPorId(s);

		Veiculo veic = veiculoService.buscarVeiculo(v);
		
		Locadora locadora = locadoraService.buscarPorId(l);
		Opcionais op = optionalService.buscarPorId(o);

		Usuario user = new Usuario();
		user.setId(30);
		veic.setLocadoraDevolucao(locadora);
		veic.setOpcionais(op);
		locacao.setDataEntrega(localDatee);
		locacao.setDataRetirada(localDate);
		locacao.setVeiculo(veic);
		locacao.setSeguro(seg);
		locacao.setValorTotal(valorTotal);
		locacao.setUsuario(user);
		
		veiculoService.save(veic);
		Locacao loca = locacaoService.save(locacao);
		System.out.println("Id_Locacao: "  + loca.getId_locacao());
		return "/home";
		
	}

}