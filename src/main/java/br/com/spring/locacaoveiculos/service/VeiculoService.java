package br.com.spring.locacaoveiculos.service;

import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Veiculo;

public interface VeiculoService {

	Veiculo save(Veiculo veiculo);

	Veiculo [] buscarTodos();

	Optional<Veiculo> buscarPeloId(Long id);

	Veiculo buscarVeiculo(Long id);

	/*List<Veiculo> buscarPorNome(String nome);*/

<<<<<<< HEAD
	Veiculo [] buscarPorDatasAndNome(LocalDate retirada, LocalDate devolucao, String nome);
=======
	List<Veiculo> buscarPorDatasAndNome(LocalDate retirada, LocalDate devolucao, String nome);
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320

	

}
