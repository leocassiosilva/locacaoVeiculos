package br.com.spring.locacaoveiculos.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.locacaoveiculos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
