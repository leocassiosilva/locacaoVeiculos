package br.com.spring.locacaoveiculos.service;

import java.util.Optional;


import br.com.spring.locacaoveiculos.model.Locadora;

public interface LocadoraService {
	Locadora [] buscarTodos();
	Optional<Locadora> buscarPorId(Long id);
	Locadora buscarLocadora(Long id);
}
