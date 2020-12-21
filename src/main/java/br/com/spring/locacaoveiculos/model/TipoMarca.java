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
@Table(name = "TIPOMARCA")
public class TipoMarca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_tipo_marca;
	
	
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
		
	public Long getId_tipo_marca() {
		return id_tipo_marca;
	}

	public void setId_tipo_marca(Long id_tipo_marca) {
		this.id_tipo_marca = id_tipo_marca;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
