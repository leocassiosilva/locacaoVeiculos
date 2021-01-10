package br.com.spring.locacaoveiculos.service;

import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Opcionais;

public interface OpcionaisService {
	Opcionais [] buscarTodosOpcionais();
	Optional<Opcionais> buscarPeloId(Long id);
	Opcionais  buscarPorId(Long id);
}
