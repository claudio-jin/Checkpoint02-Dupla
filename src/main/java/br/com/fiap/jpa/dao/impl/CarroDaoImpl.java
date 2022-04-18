package br.com.fiap.jpa.dao.impl;

import br.com.fiap.entity.Carro;

public class CarroDaoImpl extends HibernateGenericDao<Carro, Long>{

private static CarroDaoImpl instance = null;
	
	public static CarroDaoImpl getInstance() {
		if (instance == null) {
			instance = new CarroDaoImpl();
		}
		
		return instance;
	}
	
	private CarroDaoImpl() {
		super(Carro.class);
	}
}
