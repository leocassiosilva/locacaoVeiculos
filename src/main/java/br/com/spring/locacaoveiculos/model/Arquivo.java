package br.com.spring.locacaoveiculos.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Arquivo {


	private Long id_arquivo;
	
	private String nome;
		
	private Veiculo veiculo;

	public Long getId_arquivo() {
		return id_arquivo;
	}

	public void setId_arquivo(Long id_arquivo) {
		this.id_arquivo = id_arquivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
}
