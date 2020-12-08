package br.com.spring.locacaoveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Local;


@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{
	
	@Query(name=" buscarLocal", value = "Select * FROM local \n"
			+ "where local.id = :id", nativeQuery = true)
	Local buscarLocal(@Param("id") Long id);
}
