package br.com.spring.locacaoveiculos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@SuppressWarnings("serial")
@Entity
@Table(name = "LOCADORA")
public class Locadora extends AbstractEntity<Long>{

	
	private String nome;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_local")
	@JsonIgnore
	private Local localLocadora;
	
	
	@OneToMany(mappedBy = "locadora")
	@JsonIgnore
	private List<Veiculo> locadora;
	
	@OneToMany(mappedBy = "locadoraDevolucao")
	@JsonIgnore
	private List<Veiculo> locadoraDevolucao;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Local getLocalLocadora() {
		return localLocadora;
	}

	public void setLocalLocadora(Local localLocadora) {
		this.localLocadora = localLocadora;
	}
	
	
}
