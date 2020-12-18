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
@Table(name = "TIPOMARCA")
public class TipoMarca extends AbstractEntity<Long>{
	
	@ManyToOne
    @JoinColumn(name = "id_marca")
	@JsonIgnore
    private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	@JsonIgnore
	private Tipo tipo;
	
	@OneToMany(mappedBy = "tipoMarca")
	@JsonIgnore
	private List<Veiculo> veiculos;

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
