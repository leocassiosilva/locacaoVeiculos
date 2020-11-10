package br.com.spring.locacaoveiculos.service;

import java.util.List;
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Marca;


public interface MarcaService {

	List<Marca> buscarTodos();
	List<Marca> buscarMarcaPeloTipo(Long id);
	Optional<Marca> buscarPorId(Long id);
}
