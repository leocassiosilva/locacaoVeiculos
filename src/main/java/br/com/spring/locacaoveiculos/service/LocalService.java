package br.com.spring.locacaoveiculos.service;

import java.util.List;
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Local;


public interface LocalService {
	List<Local> buscarTodos();
	Optional<Local> buscarPorId(Long id);
}
