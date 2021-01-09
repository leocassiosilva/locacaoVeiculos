package br.com.spring.locacaoveiculos.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.spring.locacaoveiculos.model.Usuario;
import br.com.spring.locacaoveiculos.service.UsuarioService;
import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private WebClient wcLocadora = WebClient.create("https://projeto-pag-web.herokuapp.com/");
	
	public Usuario save(Usuario usuario) {
		try {
			Mono<Usuario> mono = this.wcLocadora.post()
					.uri(uriBuilder -> uriBuilder 
					.path("api/usuarios/save")
				    .queryParam("nome", usuario.getNome())
					.queryParam("email", usuario.getEmail())
					.queryParam("senha", usuario.getSenha()).build())
					.retrieve().bodyToMono(Usuario.class);
			Usuario user = mono.block();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public Usuario login(Usuario usuario) {
		try {
			Mono<Usuario> mono = this.wcLocadora.post()
					.uri(uriBuilder -> uriBuilder
					.path("api/usuarios/login")
					.queryParam("email", usuario.getEmail())
					.queryParam("senha", usuario.getSenha()).build())
					.retrieve().bodyToMono(Usuario.class);
			Usuario user = mono.block();
			return user;
		} catch (Exception e) {
			return null;
		}
	}
}
