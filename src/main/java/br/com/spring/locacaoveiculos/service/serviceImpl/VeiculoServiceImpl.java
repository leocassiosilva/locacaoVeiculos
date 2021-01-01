package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.VeiculoService;
import reactor.core.publisher.Mono;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private WebClient  webClientVeiculos;
	
	public Veiculo [] buscarTodos() {
		
		Mono<Veiculo []> mono = this. webClientVeiculos.get().uri("/api/veiculos").retrieve()
				.bodyToMono(Veiculo [].class);
		
		Veiculo [] veiculos =  mono.block();

		return veiculos;

	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public Veiculo save(Veiculo veiculo) {
		return null;
	}
	
	@Override
	public Optional<Veiculo> buscarPeloId(Long id) {
		return null;
	}

	@Override
	public Veiculo buscarVeiculo(Long id) {
		return null;
	}

	
	@Override
	public List<Veiculo> buscarPorDatasAndNome(LocalDate retirada, LocalDate devolucao, String nome) {
		return null;
	}

	

}
