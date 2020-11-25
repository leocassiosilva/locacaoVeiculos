package br.com.spring.locacaoveiculos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOCAL")
public class local extends AbstractEntity<Long>{
	
	private String nome;
	
	@OneToMany(mappedBy = "localRetirada")
	private List<Locacao> locacaoRetirada;
	
	@OneToMany(mappedBy = "localEntrega")
	private List<Locacao> locacaoEntrega;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
