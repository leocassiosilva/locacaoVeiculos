package br.com.spring.locacaoveiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.spring.locacaoveiculos.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	
	@Query(name="buscarTodos", value = "Select * FROM veiculos as v inner join arquivos as ar on(v.id = ar.id_veiculo)", nativeQuery = true)
	List<Veiculo> buscarTodos();
}
