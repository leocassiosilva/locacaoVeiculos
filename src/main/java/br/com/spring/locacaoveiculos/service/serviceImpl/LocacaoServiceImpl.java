package br.com.spring.locacaoveiculos.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.service.LocacaoService;
import reactor.core.publisher.Mono;

@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private WebClient webClientVeiculos;

	@Override
	public Locacao save(Locacao locacao) {
		return null;
	}

	@Override
	public Locacao[] buscarPeloUsuarioEmail(String email) {
<<<<<<< HEAD
		Mono<Locacao[]> mono = this.webClientVeiculos.get().uri("/api/locacoes/" + email).retrieve()
				.bodyToMono(Locacao[].class);
		Locacao[] locacoes = mono.block();
=======
<<<<<<< HEAD
		Mono<Locacao[]> mono = this.webClientVeiculos.get().uri("/api/locacoes/" + email).retrieve()
				.bodyToMono(Locacao[].class);
		Locacao[] locacoes = mono.block();
=======
		Mono<Locacao[]> mono = this.webClientVeiculos.get().uri("/api/locacoes/{email}").retrieve()
				.bodyToMono(Locacao[].class);
		Locacao[] locacoes = mono.block();

>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
		return locacoes;
	}

	@Override
	public Locacao[] buscarPeloId(Long id) {
		return null;
	}

}
