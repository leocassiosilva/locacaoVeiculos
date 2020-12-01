package br.com.spring.locacaoveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Locadora;


@Repository
public interface LocadoraRepository extends JpaRepository<Locadora, Long>{

}
