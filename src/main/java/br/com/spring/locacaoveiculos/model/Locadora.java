package br.com.spring.locacaoveiculos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "LOCADORA")
public class Locadora implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_locadora;
	
	
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
	

	
	
	
	public Long getId_locadora() {
		return id_locadora;
	}

	public void setId_locadora(Long id_locadora) {
		this.id_locadora = id_locadora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
