package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import br.com.spring.locacaoveiculos.model.Seguro;
import br.com.spring.locacaoveiculos.service.SeguroService;
import reactor.core.publisher.Mono;

@Service
public class SeguroServiceImpl implements SeguroService {

	@Autowired
	private WebClient webClientVeiculos;

	@Override
	public Seguro[] buscarTodos() {

		Mono<Seguro[]> mono = this.webClientVeiculos.get().uri("/api/veiculos/seguros").retrieve()
				.bodyToMono(Seguro[].class);

		Seguro[] seguros = mono.block();

		return seguros;

	}

	@Override
	public Seguro buscarPorId(Long id) {
		Mono<Seguro> mono = this.webClientVeiculos.get().uri("/api/seguro/{id}", id).retrieve()
				.bodyToMono(Seguro.class);
		Seguro seguro = mono.block();

		return seguro;
	}

	@Override
	public Optional<Seguro> buscarPeloId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
