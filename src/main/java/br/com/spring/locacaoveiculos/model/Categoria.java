package br.com.spring.locacaoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Categoria {
	
	
	private Long id_categoria;
	
	private String nome;
	
	private Float valor;
	

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
