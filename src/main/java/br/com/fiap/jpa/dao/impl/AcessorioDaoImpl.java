package br.com.fiap.jpa.dao.impl;

import br.com.fiap.entity.Acessorio;

public class AcessorioDaoImpl extends HibernateGenericDao<Acessorio, Long>{

	private static AcessorioDaoImpl instance = null;
	
	public static AcessorioDaoImpl getInstance() {
		if (instance == null) {
			instance = new AcessorioDaoImpl();
		}
		
		return instance;
	}
	
	private AcessorioDaoImpl() {
		super(Acessorio.class);
	}
}
