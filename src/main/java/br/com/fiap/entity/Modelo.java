package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_modelo")
@SequenceGenerator(name = "modelo", sequenceName = "SQ_TB_MODELO", allocationSize = 1)
public class Modelo implements Serializable{

	private static final long serialVersionUID = 2533169396448966419L;
	
	public Modelo() {} 
	
	public Modelo( String descricao) {
		this();
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modelo")
	private Long id;
	
	@Column(name = "ds_descricao", length = 200, nullable =  false)
	private String descricao;
	
	@OneToMany(mappedBy = "modelo")
	private List<Carro> carros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
	@Override
	public String toString() {
		return "Descrição: " + this.getDescricao(); 
	}
	
}
