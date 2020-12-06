package br.com.spring.locacaoveiculos.controller;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.model.Locadora;
import br.com.spring.locacaoveiculos.model.Local;
import br.com.spring.locacaoveiculos.model.Seguro;
import br.com.spring.locacaoveiculos.model.Usuario;
import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.LocacaoService;
import br.com.spring.locacaoveiculos.service.LocadoraService;
import br.com.spring.locacaoveiculos.service.LocalService;
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
	private LocalService localService;
	
	@Autowired
	private LocadoraService locadoraService;
	
	@Autowired
	private LocacaoService locacaoService;
	
	
	@GetMapping("/veiculo/{id}")
	public String preLocacao(@PathVariable("id") Long id, ModelMap model, Locacao locacao) {
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
	public String pagarLocacao(@Valid Locacao locacao, BindingResult result,  String dataRetirada, String dataEntrega,  Veiculo veiculo, ModelMap model) {
		
		/*Convertendo datas de string para LocalDate*/
	    LocalDate localDate = LocalDate.parse(dataEntrega);
        LocalDate localDatee = LocalDate.parse(dataRetirada);
		
	
        locacao.setVeiculo(veiculo);
        locacao.setDataEntrega(localDate);
        locacao.setDataRetirada(localDatee);
        
        
		System.out.println(locacao.getVeiculo().getNome());
		
		model.addAttribute("id", locacao.getVeiculo().getId());
		
		
		Veiculo veic = veiculoService.buscarVeiculo(locacao.getVeiculo().getId());
		
		System.out.println(veic.getNome());
    
        
        long diaria = ChronoUnit.DAYS.between(localDatee, localDate);
        
        System.out.println("Diarias: " + diaria);
		System.out.println("Pague a locação rapaz!");
		System.out.println(dataRetirada);
		System.out.println(localDate);
		System.out.println(veiculo.getId());
		
		System.out.println("Local de devolução: " + veiculo.getLocadoraDevolucao().getLocalLocadora().getNome());
		
		
		double seguro = veiculo.getSeguro().getPreco();
		double valorLocacao = veiculo.getCategoria().getValor() * diaria;
		double valorTotal = (valorLocacao + (seguro * diaria) );
		System.out.println(veiculo.getSeguro().getPreco() + veiculo.getCategoria().getValor());
		
		locacao.setValorTotal(valorTotal);
		
		model.addAttribute("diarias", diaria);
		model.addAttribute("valorLocacao", valorLocacao);
		model.addAttribute("valorTotal", valorTotal);
		model.addAttribute("seguro", seguro);
		model.addAttribute("dataEntrega", localDate);
		model.addAttribute("veiculo", veiculo);
		model.addAttribute("dataRetirada", localDatee);
		model.addAttribute("loca", locacao);

		
		return "/locacao/pagarLocacao";

	}

		
	@PostMapping("/confirmar")
	public String pagarLocacao(@Valid Locacao locacao, BindingResult result) {
		locacaoService.save(locacao);
		System.out.println(locacao.getDataEntrega());
		System.out.println(locacao.getDataRetirada());
		System.out.println(locacao.getUsuario());
		System.out.println(locacao.getValorTotal());
		System.out.println("Deu certo!");
		return "/home";
	}
	
	@ModelAttribute("locadoras")
	public List<Locadora> listaLocadora() {
		return locadoraService.buscarTodos();
	}
}