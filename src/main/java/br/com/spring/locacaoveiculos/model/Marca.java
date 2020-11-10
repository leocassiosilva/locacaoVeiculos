package br.com.spring.locacaoveiculos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "MARCA")
public class Marca extends AbstractEntity<Long> {

	private String nome;
	
	@OneToMany(mappedBy = "marca")
	private List<Veiculo> veiculos;
	
	
	 @OneToMany(mappedBy = "marca")
	 private List<TipoMarca> tipo_marcas;
	
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
