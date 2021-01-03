package br.com.spring.locacaoveiculos.service;

import java.util.List;


import br.com.spring.locacaoveiculos.model.Arquivo;

public interface ArquivoService {

	Arquivo save (Arquivo arquivo);
	List<Arquivo> buscarTodos();

}
