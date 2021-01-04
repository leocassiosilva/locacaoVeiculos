package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.spring.locacaoveiculos.model.Opcionais;
import br.com.spring.locacaoveiculos.service.OpcionaisService;
import reactor.core.publisher.Mono;

@Service
public class OpcionaisServiceImpl implements OpcionaisService{

	@Autowired
	private WebClient webClientVeiculos;
	
	@Override
	public Optional<Opcionais> buscarPorId(Long id) {
		return null;
	}

	@Override
	public Opcionais buscarOpcionais(Long id) {
		return null;
	}

	@Override
	public Opcionais[] buscarTodosOpcionais() {
		Mono<Opcionais[]> mono = this.webClientVeiculos.get().uri("/api/veiculos/opcionais").retrieve().bodyToMono(Opcionais[].class);

		Opcionais[] opcionais = mono.block();

		return opcionais;
	}

}
