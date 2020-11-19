package br.com.spring.locacaoveiculos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "TIPO")
public class Tipo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_tipo;
	
	private String nome;
		
	
	@OneToMany(mappedBy = "tipo")
	private List<TipoMarca> tipo_marcas;


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
