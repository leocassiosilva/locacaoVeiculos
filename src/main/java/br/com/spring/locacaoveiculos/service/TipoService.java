package br.com.spring.locacaoveiculos.service;
import java.util.List;
import java.util.Optional;

import br.com.spring.locacaoveiculos.model.Tipo;


public interface TipoService {
	List<Tipo> buscarTodosTipos(); 
	Optional<Tipo> buscarPorId(Long id);
}
