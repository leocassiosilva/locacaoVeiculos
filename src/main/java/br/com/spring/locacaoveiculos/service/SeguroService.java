package br.com.spring.locacaoveiculos.service;

import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Seguro;

public interface SeguroService {
	Seguro [] buscarTodos();
	Optional<Seguro> buscarPorId(Long id);
}
