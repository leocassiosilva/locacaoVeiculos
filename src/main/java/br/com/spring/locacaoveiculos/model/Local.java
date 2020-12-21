package br.com.spring.locacaoveiculos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "LOCAL")
public class Local implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_local;
	
	private String nome;
	

	@OneToMany(mappedBy = "localLocadora")
	@JsonIgnore
	private List<Locadora> localLocadora;


	public Long getId_local() {
		return id_local;
	}


	public void setId_local(Long id_local) {
		this.id_local = id_local;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Locadora> getLocalLocadora() {
		return localLocadora;
	}


	public void setLocalLocadora(List<Locadora> localLocadora) {
		this.localLocadora = localLocadora;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
