package br.com.spring.locacaoveiculos.service;

import java.time.LocalDate;
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Veiculo;

public interface VeiculoService {

	void save(Veiculo veiculo);

	Veiculo [] buscarTodos();

	Optional<Veiculo> buscarPeloId(Long id);

	Veiculo buscarVeiculo(Long id);

	/*List<Veiculo> buscarPorNome(String nome);*/

	Veiculo [] buscarPorDatasAndNome(LocalDate retirada, LocalDate devolucao, String nome);

	

}
