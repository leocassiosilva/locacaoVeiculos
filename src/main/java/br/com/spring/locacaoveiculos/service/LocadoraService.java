package br.com.spring.locacaoveiculos.service;

import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Locadora;

public interface LocadoraService {
	Locadora[] buscarTodos();

	Locadora buscarPorId(Long id);
	
	Optional<Locadora> buscar(Long id);

}
