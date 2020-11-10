package br.com.spring.locacaoveiculos.service;

import java.util.List;


import br.com.spring.locacaoveiculos.model.Veiculo;

public interface VeiculoService {

	Veiculo save(Veiculo veiculo);
	List <Veiculo> buscarTodos();
}
