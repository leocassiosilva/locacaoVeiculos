package br.com.spring.locacaoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Local {

	private Long id_local;

	private String nome;

	public Long getId_local() {
		return id_local;
	}

	public void setId_local(Long id_local) {
		this.id_local = id_local;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
