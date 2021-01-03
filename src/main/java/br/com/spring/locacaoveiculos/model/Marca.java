package br.com.spring.locacaoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Marca {
	private Long id_marca;

	private String nome;

		
	public Long getId_marca() {
		return id_marca;
	}

	public void setId_marca(Long id_marca) {
		this.id_marca = id_marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
