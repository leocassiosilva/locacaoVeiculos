package br.com.spring.locacaoveiculos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.spring.locacaoveiculos.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	
	@Query(name="buscarTodos", value = "Select * FROM veiculos as v inner join arquivos as ar on(v.id = ar.id_veiculo)", nativeQuery = true)
	List<Veiculo> buscarTodos();
	
	@Query(name="buscarPeloId", value = "Select * FROM veiculos as v inner join arquivos as ar on(v.id = ar.id_veiculo)\n"
			+ "where v.id = :id", nativeQuery = true)
	Optional<Veiculo> buscarPeloId(@Param("id") Long id);
	
	@Query(name=" buscarVeiculo", value = "Select * FROM veiculos as v inner join arquivos as ar on(v.id = ar.id_veiculo)\n"
			+ "inner join tipomarca on(v.id_tipo_marca = tipomarca.id)\n"
			+ "inner join marca on(tipomarca.id_marca = marca.id)\n"
			+ "inner join locadora on(v.id_locadora = locadora.id)\n"
			+ "where v.id = :id", nativeQuery = true)
	Veiculo buscarVeiculo(@Param("id") Long id);
}
