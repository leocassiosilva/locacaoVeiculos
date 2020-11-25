package br.com.spring.locacaoveiculos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "SEGURO")
public class Seguro extends AbstractEntity<Long>{

	private String nome;
	
	private double preco;
	
	@OneToMany(mappedBy = "seguro")
	private List<Locacao> locacoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
