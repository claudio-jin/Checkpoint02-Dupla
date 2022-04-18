package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;

	public Carro () {}
	
	public Carro(String placa, String cor, String chassi) {
		this();
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
	}

	public Carro(String placa, String cor, String chassi, List<Acessorio> acessorios, Modelo modelo) {
		this();
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
		this.acessorios = acessorios;
		this.modelo = modelo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private Long id;
	
	@Column(name = "ds_placa", length = 10, nullable = false)
	private String placa;
	
	@Column(name = "ds_cor", length = 15, nullable = false)
	private String cor;
	
	@Column(name = "ds_chassi", length = 15, nullable = false)
	private String chassi;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "acessorio_id")
	private List<Acessorio> acessorios;
	
	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return  "ID: " + this.getId()
				+"\nPlaca: " + this.getPlaca()
				+ "\nCor: " + this.getCor()
				+ "\nChassi: " + this.getChassi()
				+ "\nModelo: " + this.getModelo() 
				+ "\nAcessorios: " + this.getAcessorios();
	}
	
	
}
