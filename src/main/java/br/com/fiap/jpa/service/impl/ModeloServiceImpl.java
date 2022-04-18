package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.entity.Modelo;
import br.com.fiap.jpa.dao.impl.ModeloDaoImpl;
import br.com.fiap.jpa.service.GenericService;

public class ModeloServiceImpl extends GenericService<Modelo, Long>{

private static ModeloServiceImpl instance = null;
	
	private ModeloDaoImpl modeloDao;
	
	private ModeloServiceImpl() {
		modeloDao = ModeloDaoImpl.getInstance();
		
	}
	
	public static ModeloServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new ModeloServiceImpl();
		}
		
		return instance;
	}
	
	
	
	@Override
	public void cadastrar(Modelo modelo) {
		try {
			modeloDao.salvar(modelo, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	@Override
	public void atualizar(Modelo modelo) {
		try {
			modeloDao.atualizar(modelo, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}		

	@Override
	public void remover(Long id) {
		try {
			modeloDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}		
	}

	@Override
	public Modelo obter(Long id) {
		Modelo modelo = null;
		
		try {
			modelo = modeloDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return modelo;
	}

	@Override
	public List<Modelo> listar() {
		List<Modelo> modelos = null;
		
		try {
			modelos = modeloDao.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return modelos;
	}
}
