package br.com.spring.locacaoveiculos.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "LOCACAO") 
public class Locacao implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_locacao;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_retirada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataRetirada;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_entrega", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrega;
	
	private double valorTotal; 

	
	public Long getId_locacao() {
		return id_locacao;
	}

	public void setId_locacao(Long id_locacao) {
		this.id_locacao = id_locacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	

	

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	
	
}
