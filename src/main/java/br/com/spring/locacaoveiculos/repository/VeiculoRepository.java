package br.com.spring.locacaoveiculos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.spring.locacaoveiculos.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	@Query(name = "buscarTodos", value = "Select * FROM veiculos as v "
			+ "inner join arquivos as ar on(v.id_veiculo = ar.id_veiculo)", nativeQuery = true)
	List<Veiculo> buscarTodos();

	@Query(name = "buscarPeloId", value = "Select * FROM veiculos as v "
			+ "inner join arquivos as ar on(v.id_veiculo = ar.id_veiculo)\n"
			+ "where v.id_veiculo = :id", nativeQuery = true)
	Optional<Veiculo> buscarPeloId(@Param("id") Long id);

	@Query(name = " buscarVeiculo", value = "Select * FROM veiculos as v "
			+ "inner join arquivos as ar on(v.id_veiculo = ar.id_veiculo)\n"
			+ "inner join tipomarca on(v.id_tipo_marca = tipomarca.id_tipo_marca)\n"
			+ "inner join marca on(tipomarca.id_marca = marca.id_marca)\n"
			+ "inner join locadora on(v.id_locadora = locadora.id_locadora)\n"
			+ "where v.id_veiculo = :id", nativeQuery = true)
	Veiculo buscarVeiculo(@Param("id") Long id);

	@Query(name = "buscarPorNome", value = "SELECT * FROM veiculos\n"
			+ "inner join arquivos on (veiculos.id_veiculo = arquivos.id_veiculo)\n"
			+ "inner join locadora on (veiculos.id_locadora = locadora.id_locadora)\n"
			+ "inner join local on(locadora.id_local = local.id_local)\n"
			+ "where local.nome = :nome", nativeQuery = true)
	List<Veiculo> buscarPorNome(String nome);

	@Query(name = "dataEntradaDataSaida", value = "SELECT * FROM veiculos as v "
			+ "where v.id NOT IN (SELECT locacao.id_veiculo FROM locacao "
			+ "where (locacao.data_retirada <= and locacao.data_retirada >= ) "
			+ "or (locacao.data_entrega >=  and locacao.data_entrega <= ))", nativeQuery = true)
	List<Veiculo> dataEntradaDataSaida(LocalDate entrada, LocalDate saida);

	@Query(name = "dataEntrada", value = "SELECT * FROM veiculos as v "
			+ "where v.id NOT IN (SELECT locacao.id_veiculo FROM locacao "
			+ "where (locacao.data_retirada <= and locacao.data_retirada >= ))", nativeQuery = true)
	List<Veiculo> dataEntrada(LocalDate entrada);

	@Query(name = "dataSaida", value = "SELECT * FROM veiculos as v "
			+ "where v.id NOT IN (SELECT locacao.id_veiculo FROM locacao "
			+ "where (locacao.data_entrega >=  and locacao.data_entrega <= ))", nativeQuery = true)
	List<Veiculo> dataSaida(LocalDate saida);

}
