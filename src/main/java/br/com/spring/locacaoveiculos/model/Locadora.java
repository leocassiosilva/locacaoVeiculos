package br.com.spring.locacaoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Locadora {

	private Long id_locadora;

	private String nome;

	private Local localLocadora;

	public Long getId_locadora() {
		return id_locadora;
	}

	public void setId_locadora(Long id_locadora) {
		this.id_locadora = id_locadora;
	}

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
