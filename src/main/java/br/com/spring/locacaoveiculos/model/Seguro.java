package br.com.spring.locacaoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seguro {
	
	private Long id_seguro;
	
	private String nome;
	
	private double preco;
	

	
	public Long getId_seguro() {
		return id_seguro;
	}

	public void setId_seguro(Long id_seguro) {
		this.id_seguro = id_seguro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
