package br.com.spring.locacaoveiculos.service;

import br.com.spring.locacaoveiculos.model.Usuario;

public interface UsuarioService {

	Usuario save(Usuario usuario);
	Usuario login(Usuario usuario);
	
}
