package br.com.spring.locacaoveiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>{
	
		
	@Query(name="buscarPeloUsuario", value = "SELECT * FROM usuario inner join locacao\n"
			+ "on(locacao.id_usuario = usuario.id_usuario)inner join veiculos\n"
			+ "on(locacao.id_veiculo = veiculos.id_veiculo) where usuario.email = :email", nativeQuery = true)
	List<Locacao> buscarPeloUsuario(@Param("email") String email);
	
	@Query(name="buscarPeloUsuario", value = "SELECT * FROM locacao  where locacao.id_usuario = :id", nativeQuery = true)
	List<Locacao> buscarPeloId(@Param("id") Long id);
}
