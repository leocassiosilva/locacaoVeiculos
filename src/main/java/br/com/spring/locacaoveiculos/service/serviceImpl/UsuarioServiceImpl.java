package br.com.spring.locacaoveiculos.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Usuario;
import br.com.spring.locacaoveiculos.repository.UsuarioRepository;
import br.com.spring.locacaoveiculos.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
