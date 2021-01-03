package br.com.spring.locacaoveiculos.controller;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.model.Locadora;
import br.com.spring.locacaoveiculos.model.Local;
import br.com.spring.locacaoveiculos.model.Opcionais;
import br.com.spring.locacaoveiculos.model.Seguro;
import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.LocacaoService;
import br.com.spring.locacaoveiculos.service.LocadoraService;
import br.com.spring.locacaoveiculos.service.LocalService;
import br.com.spring.locacaoveiculos.service.OpcionaisService;
import br.com.spring.locacaoveiculos.service.SeguroService;
import br.com.spring.locacaoveiculos.service.VeiculoService;


@Controller
@RequestMapping("locacaos")
public class LocacaoveiculosController {

	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private SeguroService seguroService;
	
	@Autowired
	private OpcionaisService opcionaisService;
	
	@Autowired
	private LocalService localService;
	
	@Autowired
	private LocadoraService locadoraService;
	
	@Autowired
	private LocacaoService locacaoService;
	
	
	@GetMapping("/veiculo/{id}")
	public String preLocacao(@PathVariable("id") Long id, ModelMap model, Locacao locacao, @RequestParam("dataRetirar") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataRetirar, @RequestParam("dataDevolver") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolver) {
		System.out.println(id);
		model.addAttribute("dataRetirar", dataRetirar);
		model.addAttribute("dataDevolver", dataDevolver);
		
		model.addAttribute("veiculo", veiculoService.buscarVeiculo(id)); 
		System.out.println(veiculoService.buscarVeiculo(id));
		return "locacao/cadastroLocacao";

	}
	
	@ModelAttribute("seguros")
	public List<Seguro> listaSeguros() {
		return seguroService.buscarTodos();
	}
	
	@ModelAttribute("opcional")
	public List<Opcionais> listaOpcionais() {
		return opcionaisService.buscarTodos();
	}
	
	@ModelAttribute("locais")
	public List<Local> listaLocais() {
		return localService.buscarTodos();
	}
	
	
	@PostMapping("/pagar")
	public String pagarLocacao(@Valid Locacao locacao, BindingResult result,  String dataRetirar, String dataDevolver,  Veiculo veiculo, ModelMap model) {
		
		/*Convertendo datas de string para LocalDate*/
	    LocalDate localDate = LocalDate.parse(dataDevolver);
        LocalDate localDatee = LocalDate.parse(dataRetirar);
        /*Serve para calcular quantidade de dias entre datas*/
        long diaria = ChronoUnit.DAYS.between(localDatee, localDate);  
        	  
        System.out.println("Diarias: " + diaria);
		System.out.println("Pague a locação rapaz!");
		System.out.println(dataRetirar);
		System.out.println(localDate);
		System.out.println(veiculo.getId_veiculo());
		
		System.out.println("Id - Seguro: " + veiculo.getSeguro().getId_seguro());
		
		System.out.println("Id - Opcionais: " + veiculo.getOpcionais().getId_opc());
		
		System.out.println("Id - Local devolução: " + veiculo.getLocadoraDevolucao().getId_locadora());
		
		System.out.println("Local de devolução: " + veiculo.getLocadoraDevolucao().getLocalLocadora().getNome());
		
		System.out.println("Categoria = " + veiculo.getCategoria().getId_categoria());
		/**/
		double seguro = veiculo.getSeguro().getPreco();
		double valorLocacao = veiculo.getCategoria().getValor() * diaria;
		double valorTotal = (valorLocacao + (seguro * diaria) );
		System.out.println(veiculo.getSeguro().getPreco() + veiculo.getCategoria().getValor());
		
		model.addAttribute("seg", veiculo.getSeguro().getId_seguro());
		model.addAttribute("opc", veiculo.getOpcionais().getId_opc());
  		model.addAttribute("locadoraDevolucaoId", veiculo.getLocadoraDevolucao().getId_locadora());
		model.addAttribute("diarias", diaria);
		model.addAttribute("valorLocacao", valorLocacao);
		model.addAttribute("valorTotal", valorTotal);
		model.addAttribute("seguro", seguro);
		model.addAttribute("dataEntrega", localDate);
		model.addAttribute("veiculo", veiculo);
		model.addAttribute("dataRetirada", localDatee);
		model.addAttribute("loca", locacao);
		
		//veiculoService.save(veiculo);
		return "/locacao/pagarLocacao";

	}

		
	@PostMapping("/confirmar")
	public String pagarLocacao(@Valid Locacao locacao, BindingResult result, Long seg, Long id_veiculo, Long locadoraDevolucaoId) {
		
		Veiculo veic = veiculoService.buscarVeiculo(id_veiculo);
		
		String nome = veic.getNome();
		
		System.out.println("Id: " + nome);
		Locadora locadora = locadoraService.buscarLocadora(seg);
		
		Seguro seguro = seguroService.buscarSeguro(locadoraDevolucaoId);
		
		/*Adiciono no veiculo o seguro e a locadora na qual o usuario vai deixar o veiculo*/
		veic.setSeguro(seguro);
		veic.setLocadoraDevolucao(locadora);
		
		System.out.println(veic.getLocadoraDevolucao());
		/*Aqui dou update para atualizar no banco o veiculo as informaçoes do veiculo!*/
		veiculoService.save(veic);
		
		locacao.setVeiculo(veic);
		
		/*Salvo a locação!*/
		locacaoService.save(locacao);
		System.out.println("Deu certo!");
		return "/home";
	}
	
	@ModelAttribute("locadoras")
	public List<Locadora> listaLocadora() {
		return locadoraService.buscarTodos();
	}
	
	@GetMapping(value = "/getUsuario/{email}")
	@ResponseBody
	public List<Locacao> relatorio(@PathVariable("email") String email, ModelMap model) {
		
		List<Locacao> locacaoUser = locacaoService.buscarPeloUsuario(email);
		model.addAttribute("locacaoUser", locacaoUser);

		return locacaoService.buscarPeloUsuario(email);
	}
}