package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.time.LocalDate;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
	private WebClient webClientVeiculos;

	public Veiculo[] buscarTodos() {

		Mono<Veiculo[]> mono = this.webClientVeiculos.get().uri("/api/veiculos").retrieve().bodyToMono(Veiculo[].class);

		Veiculo[] veiculos = mono.block();
<<<<<<< HEAD
=======
=======
	private WebClient  webClientVeiculos;
	
	public Veiculo [] buscarTodos() {
		
		Mono<Veiculo []> mono = this. webClientVeiculos.get().uri("/api/veiculos").retrieve()
				.bodyToMono(Veiculo [].class);
		
		Veiculo [] veiculos =  mono.block();
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d

		return veiculos;

	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
	@Override
	public Veiculo save(Veiculo veiculo) {
		return null;
	}
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
	
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
	@Override
	public Optional<Veiculo> buscarPeloId(Long id) {
		return null;
	}

	@Override
	public Veiculo buscarVeiculo(Long id) {
		return null;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
	@Override
	public Veiculo[] buscarPorDatasAndNome(LocalDate retirada, LocalDate devolucao, String nome) {

		Mono<Veiculo[]> mono = this.webClientVeiculos.get()
				.uri("/api/veiculos/buscar/{retirada}/{devolucao}/{nome}", retirada, devolucao, nome).retrieve()
				.bodyToMono(Veiculo[].class);

		Veiculo[] veiculos = mono.block();

		return veiculos;
	}

<<<<<<< HEAD
=======
=======
	
	@Override
	public List<Veiculo> buscarPorDatasAndNome(LocalDate retirada, LocalDate devolucao, String nome) {
		return null;
	}

	

>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
}
