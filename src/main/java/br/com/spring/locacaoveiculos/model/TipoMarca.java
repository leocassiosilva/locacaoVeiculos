package br.com.spring.locacaoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoMarca {
	private Long id_tipo_marca;

	private Marca marca;

	private Tipo tipo;

	public Long getId_tipo_marca() {
		return id_tipo_marca;
	}

	public void setId_tipo_marca(Long id_tipo_marca) {
		this.id_tipo_marca = id_tipo_marca;
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
