package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.model.Usuario;
import br.com.spring.locacaoveiculos.service.LocacaoService;
import reactor.core.publisher.Mono;

@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private WebClient webClientVeiculos;
	

	private WebClient wcUsuario = WebClient.create("https://projeto-pag-api.herokuapp.com");


	@Override
	public Locacao save(Locacao locacao) {
		
		Mono<Locacao> mono = this.webClientVeiculos.post().uri("/api/locacoes/salvar")
				.body(BodyInserters.fromValue(locacao)).retrieve().bodyToMono(Locacao.class);
		Locacao locaca = mono.block();
		return locaca;
	}

	@Override
	public Locacao[] buscarPeloId(Long id) {
		System.out.println(id);
		Mono<Locacao[]> mono = this.webClientVeiculos.get().uri("/api/locacoes/{id}", id).retrieve()
				.bodyToMono(Locacao[].class);
		Locacao[] locacoes = mono.block();
		return locacoes;
	}

	@Override
	public String pagamentoLocacao(Long id_usuario, Locacao locacao, String token) {
		
		
		LocalDate dataLocacao = LocalDate.now();
		DateTimeFormatter dataLocacaoFomatada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dataLoca = dataLocacaoFomatada.format(dataLocacao);
		
		try {
			Mono<Usuario> mono = this.wcUsuario.post()
					.uri(uriBuilder -> uriBuilder
						.path("api/compras/gerarLink")
						.queryParam("id", id_usuario)
						.queryParam("valor", locacao.getValorTotal())
						.queryParam("data", dataLoca)
						.build())
					.header("Origem", "http://localhost:8080/home")
					.header("Authorization", "Bearer " + token)
					.retrieve()
					.bodyToMono(Usuario.class);
			Usuario usuario = mono.block();
			
			return usuario.getLink();
		} catch (Exception e) {
			return null;
		}
		
	}

}
