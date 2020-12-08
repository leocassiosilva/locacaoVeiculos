package br.com.spring.locacaoveiculos.service;

import java.util.List;
import java.util.Optional;


import br.com.spring.locacaoveiculos.model.Locadora;

public interface LocadoraService {
	List<Locadora> buscarTodos();
	Optional<Locadora> buscarPorId(Long id);
	Locadora buscarLocadora(Long id);
}
