package br.com.fiap.jpa.dao.impl;

import br.com.fiap.entity.Modelo;

public class ModeloDaoImpl extends HibernateGenericDao<Modelo, Long>{

	private static ModeloDaoImpl instance = null;
	
	public static ModeloDaoImpl getInstance() {
		if (instance == null) {
			instance = new ModeloDaoImpl();
		}
		
		return instance;
	}
	
	private ModeloDaoImpl() {
		super(Modelo.class);
	}

}
