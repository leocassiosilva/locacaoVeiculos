package br.com.spring.locacaoveiculos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@SuppressWarnings("serial")
@Entity
@Table(name = "LOCAL")
public class Local extends AbstractEntity<Long>{
	
	private String nome;
	

	@OneToMany(mappedBy = "localLocadora")
	@JsonIgnore
	private List<Locadora> localLocadora;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
