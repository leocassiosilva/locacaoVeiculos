package br.com.spring.locacaoveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Seguro;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long>{
	
	@Query(name=" buscarSeguro", value = "Select * FROM seguro \n"
			+ "where seguro.id_seguro = :id", nativeQuery = true)
	Seguro buscarSeguro(@Param("id") Long id);
}
