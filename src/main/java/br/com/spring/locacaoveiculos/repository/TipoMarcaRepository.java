package br.com.spring.locacaoveiculos.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.TipoMarca;
@Repository
public interface TipoMarcaRepository extends JpaRepository<TipoMarca, Long>{

	Optional<TipoMarca> findById(Long id);
	
	@Query(name="buscarTipoMarca", value = "SELECT * FROM tipomarca  WHERE tipomarca.id_tipo = :id and tipomarca.id_marca = :id_marca", nativeQuery = true)
	TipoMarca buscarTipoMarca(@Param("id") Long id, @Param("id_marca") Long id_marca);

}
