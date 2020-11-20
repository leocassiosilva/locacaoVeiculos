package br.com.spring.locacaoveiculos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOCACAO") 
public class Locacao extends AbstractEntity<Long>{

	
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_localRetirada")
	private Local localRetirada;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_localEntrega")
	private Local localEntrega;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_retirada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataRetirada;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_entrega", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrega;

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

	public Local getLocalRetirada() {
		return localRetirada;
	}

	public void setLocalRetirada(Local localRetirada) {
		this.localRetirada = localRetirada;
	}

	public Local getLocalEntrega() {
		return localEntrega;
	}

	public void setLocalEntrega(Local localEntrega) {
		this.localEntrega = localEntrega;
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
