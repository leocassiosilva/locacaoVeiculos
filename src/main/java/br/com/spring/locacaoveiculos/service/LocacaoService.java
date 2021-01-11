package br.com.spring.locacaoveiculos.service;

import br.com.spring.locacaoveiculos.model.Locacao;

public interface LocacaoService {
	Locacao save(Locacao locacao);
	
	Locacao [] buscarPeloUsuarioEmail(String email);
	
	Locacao [] buscarPeloId(Long id);
	
	String pagamentoLocacao(Long id_usuario, Locacao locacao, String token);
	
}
