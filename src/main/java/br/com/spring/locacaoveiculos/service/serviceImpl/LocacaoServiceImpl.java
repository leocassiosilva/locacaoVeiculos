package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.service.LocacaoService;
import reactor.core.publisher.Mono;

@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private WebClient webClientVeiculos;
	

	private WebClient wcUsuario = WebClient.create("https://projeto-pag-api.herokuapp.com");
	
	@Override
	public Locacao[] buscarPeloUsuarioEmail(String usuario) {
		Mono<Locacao[]> mono = this.webClientVeiculos.get().uri("/api/locacoes/finduser/{usuario}" + usuario).retrieve()
				.bodyToMono(Locacao[].class);
		Locacao[] locacoes = mono.block();
		return locacoes;
	}

	@Override
	public Locacao save(Locacao locacao) {
		
		Mono<Locacao> mono = this.webClientVeiculos.post().uri("/api/locacoes/salvar")
				.body(BodyInserters.fromValue(locacao)).retrieve().bodyToMono(Locacao.class);
		Locacao locaca = mono.block();
		return locaca;
	}

	@Override
	public Locacao[] buscarPeloId(Long id) {
		return null;
	}

	@Override
	public String pagamentoLocacao(Long id_usuario, Locacao locacao, String token) {
		
		
		LocalDate dataLocacao = LocalDate.now();
		DateTimeFormatter dataLocacaoFomatada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dataLoca = dataLocacaoFomatada.format(dataLocacao);
		
		
			return null;
		
	}

}
