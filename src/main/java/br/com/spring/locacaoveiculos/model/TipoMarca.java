package br.com.spring.locacaoveiculos.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TIPOMARCA")
public class TipoMarca extends AbstractEntity<Long>{
	
	@ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
}
