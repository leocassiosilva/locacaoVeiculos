package br.com.spring.locacaoveiculos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOCADORA")
public class Locadora extends AbstractEntity<Long>{

	
	private String nome;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_local")
	private Local localLocadora;
	
	
	@OneToMany(mappedBy = "locadora")
	private List<Veiculo> locadora;

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
