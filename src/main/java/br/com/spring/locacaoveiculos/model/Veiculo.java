package br.com.spring.locacaoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Veiculo {

	private Long id_veiculo;

	private String nome;

	private String placa;

	private String renavan;

	private Categoria categoria;

	private TipoMarca tipoMarca;

	private Locadora locadora;

	private Locadora locadoraDevolucao;


	private Opcionais opcionais;

	private String nomeArquivo;

	public Long getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Long id_veiculo) {
		this.id_veiculo = id_veiculo;
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

	public Opcionais getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(Opcionais opcionais) {
		this.opcionais = opcionais;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

}
