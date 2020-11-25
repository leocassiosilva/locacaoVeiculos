package br.com.spring.locacaoveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.locacaoveiculos.model.Seguro;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long>{

}
