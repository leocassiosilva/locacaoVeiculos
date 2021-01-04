package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.spring.locacaoveiculos.model.Locadora;
import br.com.spring.locacaoveiculos.service.LocadoraService;
import reactor.core.publisher.Mono;
@Service
public class LocadoraServiceImpl implements LocadoraService{

	@Autowired
	private WebClient webClientVeiculos;
	
	@Override
	public Locadora [] buscarTodos() {
		
		Mono<Locadora []> mono = this.webClientVeiculos.get().uri("/api/veiculos/locadoras").retrieve().bodyToMono(Locadora [].class);

		Locadora [] locadora = mono.block();

		return locadora;
	}

	@Override
	public Optional<Locadora> buscarPorId(Long id) {
		return null;
	}

	@Override
	public Locadora buscarLocadora(Long id) {
		return null;
	}

}
