package br.com.spring.locacaoveiculos.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long>{
	
	
	Optional<Marca> findById(Long id);
	
	@Query(name="buscarMarcaPeloTipo", value = "Select * FROM marca as m inner join tipomarca as tm on(m.id_marca = tm.id_marca)"
			+ " inner join tipo as t on(t.id_tipo = tm.id_tipo)\n" + 
			"WHERE t.id_tipo = :id", nativeQuery = true)
	List<Marca> buscarMarcaPeloTipo(@Param("id") Long id);
	

}
