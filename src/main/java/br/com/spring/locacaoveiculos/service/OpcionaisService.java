package br.com.spring.locacaoveiculos.service;

import java.util.List;
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Opcionais;

public interface OpcionaisService {
	List<Opcionais> buscarTodos();
	Optional<Opcionais> buscarPorId(Long id);
	Opcionais buscarOpcionais(Long id);
}
