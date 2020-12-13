package br.com.spring.locacaoveiculos.service;

import java.util.List;


import br.com.spring.locacaoveiculos.model.Locacao;

public interface LocacaoService {
	Locacao save(Locacao locacao);
	List<Locacao> buscarPeloUsuario(String email);
	
}
