package br.com.spring.locacaoveiculos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name = "VEICULOS")
public class Veiculo extends AbstractEntity<Long> {

   
	@NotBlank(message = "O nome do veiculo é obrigatório.")
	private String nome;

	@NotBlank(message = "A placa é obrigatório.")
	private String placa;

	@NotBlank(message = "O renavan é obrigatório.")
	private String renavan;
	
	
	@OneToMany(mappedBy = "veiculo")
	private List<Arquivo> arquivos;
	
	
	@OneToMany(mappedBy = "veiculo")
	private List<Locacao> locacoes;
	
	
	@NotNull(message = "Selecione a categoria.")
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@NotNull(message = "Selecione o tipo e a marca do veiculo.")
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_tipoMarca")
	private TipoMarca tipoMarca;

    @Type(type="true_false")
	public boolean status; 
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
