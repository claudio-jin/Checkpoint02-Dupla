package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio")
@SequenceGenerator(name = "acessorio", sequenceName = "SQ_TB_ACESSORIO", allocationSize = 1)
public class Acessorio implements Serializable{

	private static final long serialVersionUID = -2429202451974084413L;

	public Acessorio() {}
	
	public Acessorio(String descricao) {
		this();
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
	private Long id;
	
	@Column(name = "ds_descricao", length = 200, nullable =  false)
	private String descricao;
	
	@ManyToMany()
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
		return "Acessorio :" + this.getDescricao();
	}
	
	
	
}
