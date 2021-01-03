package br.com.spring.locacaoveiculos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "VEICULOS")
public class Veiculo implements Serializable{

   
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_veiculo;
	
	private String nome;

	private String placa;

	private String renavan;
	
	
	@OneToMany(mappedBy = "veiculo")
	private List<Arquivo> arquivos;
	
	
	@OneToMany(mappedBy = "veiculo")
	private List<Locacao> locacoes;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_tipoMarca")
	private TipoMarca tipoMarca;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_locadora")
	private Locadora locadora; 

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_locadora_devolucao")
	private Locadora locadoraDevolucao;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_seguro")
	private Seguro seguro;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_opc")
	private Opcionais opcionais;
	
	
	public Long getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Long id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	
	public Opcionais getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(Opcionais opcionais) {
		this.opcionais = opcionais;
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

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
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
