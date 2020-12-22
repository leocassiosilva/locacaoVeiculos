package br.com.spring.locacaoveiculos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Veiculo;

public interface VeiculoService {

	Veiculo save(Veiculo veiculo);

	List<Veiculo> buscarTodos();

	Optional<Veiculo> buscarPeloId(Long id);

	Veiculo buscarVeiculo(Long id);

	List<Veiculo> buscarPorNome(String nome);

	List<Veiculo> buscarPorDatas(LocalDate entrada, LocalDate saida);

}
