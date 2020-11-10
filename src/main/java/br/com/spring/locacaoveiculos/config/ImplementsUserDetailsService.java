package br.com.spring.locacaoveiculos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Usuario;
import br.com.spring.locacaoveiculos.repository.UsuarioRepository;

@Repository
public class ImplementsUserDetailsService  implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository ur;
	
	 
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = ur.findByEmail(email);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		 return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

}
