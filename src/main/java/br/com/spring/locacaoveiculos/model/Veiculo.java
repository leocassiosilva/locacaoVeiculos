package br.com.spring.locacaoveiculos.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Veiculo implements Serializable{

   
	private static final long serialVersionUID = 1L;
	
	private Long id_veiculo;

	private String nome;

	private String placa;

	private String renavan;

	private Categoria categoria;

	private TipoMarca tipoMarca;

	private Locadora locadora;

	private Locadora locadoraDevolucao;

	private Seguro seguro;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d
	
	private String nomeArquivo;
	

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
<<<<<<< HEAD
=======
=======
>>>>>>> efdf022296d7cf2d068707579b1194bd5b81f320
>>>>>>> 7f74d8d8a40eefce89417b5e607c061ae7f3e27d

	public Long getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Long id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public Locadora getLocadoraDevolucao() {
		return locadoraDevolucao;
	}

	public void setLocadoraDevolucao(Locadora locadoraDevolucao) {
		this.locadoraDevolucao = locadoraDevolucao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public TipoMarca getTipoMarca() {
		return tipoMarca;
	}

	public void setTipoMarca(TipoMarca tipoMarca) {
		this.tipoMarca = tipoMarca;
	}
}
