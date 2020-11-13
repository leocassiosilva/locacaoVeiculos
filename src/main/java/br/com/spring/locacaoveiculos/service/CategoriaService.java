package br.com.spring.locacaoveiculos.service;

import java.util.List;
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Categoria;


public interface CategoriaService {
	List<Categoria> buscarTodos();
	Optional<Categoria> buscarPorId(Long id);

}
