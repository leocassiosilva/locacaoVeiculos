package br.com.spring.locacaoveiculos.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.spring.locacaoveiculos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
	
	@Query(name = "buscarPeloEmail", value = "SELECT * FROM usuario\n"
			+ "Where usuario.email = :email", nativeQuery = true)
	Usuario buscarPeloEmail(@Param("email") String email);
}
