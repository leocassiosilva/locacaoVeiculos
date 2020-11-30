package br.com.spring.locacaoveiculos.service;

import java.util.List;
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Seguro;

public interface SeguroService {
	List<Seguro> buscarTodos();
	Optional<Seguro> buscarPorId(Long id);
}
