package br.com.spring.locacaoveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Opcionais;

@Repository
public interface OpcionaisRepository extends JpaRepository<Opcionais, Long>{
	
	@Query(name=" buscarOpcionais", value = "Select * FROM opcionais \n"
			+ "where opcionais.id_opc = :id", nativeQuery = true)
	Opcionais buscarOpcionais(@Param("id") Long id);
}
