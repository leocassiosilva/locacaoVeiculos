package br.com.spring.locacaoveiculos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Opcionais implements Serializable{


	private Long id_opc;
	
	private String nome;
	
	private String adicionais;
	
	
	private List<Veiculo> veiculos;
	
	public Long getId_opc() {
		return id_opc;
	}

	public void setId_seguro(Long id_opc) {
		this.id_opc = id_opc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(String adicionais) {
		this.adicionais = adicionais;
	}
	
	
}
