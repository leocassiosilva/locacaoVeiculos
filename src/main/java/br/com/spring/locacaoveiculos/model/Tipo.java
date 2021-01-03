package br.com.spring.locacaoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
<<<<<<< HEAD
public class Tipo  {

=======
public class Tipo {
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
	private Long id_tipo;

	private String nome;

	public Long getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Long id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
