package br.com.spring.locacaoveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Locadora;


@Repository
public interface LocadoraRepository extends JpaRepository<Locadora, Long>{

	@Query(name=" buscarLocadora", value = "Select * FROM locadora \n"
			+ "where locadora.id = :id", nativeQuery = true)
	Locadora buscarLocadora(@Param("id") Long id);
}
