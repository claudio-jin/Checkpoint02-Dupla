package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.entity.Acessorio;
import br.com.fiap.jpa.dao.impl.AcessorioDaoImpl;
import br.com.fiap.jpa.service.GenericService;

public class AcessorioServiceImpl extends GenericService<Acessorio, Long>{

	private static AcessorioServiceImpl instance = null;
	
	private AcessorioDaoImpl acessorioDao;
	
	private AcessorioServiceImpl() {
		acessorioDao = AcessorioDaoImpl.getInstance();
		
	}
	
	public static AcessorioServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new AcessorioServiceImpl();
		}
		
		return instance;
	}
	
	
	
	@Override
	public void cadastrar(Acessorio acessorio) {
		try {
			acessorioDao.salvar(acessorio, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	@Override
	public void atualizar(Acessorio acessorio) {
		try {
			acessorioDao.atualizar(acessorio, getEntityManager());
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
			acessorioDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}		
	}

	@Override
	public Acessorio obter(Long id) {
		Acessorio acessorio = null;
		
		try {
			acessorio = acessorioDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return acessorio;
	}

	@Override
	public List<Acessorio> listar() {
		List<Acessorio> acessorios = null;
		
		try {
			acessorios = acessorioDao.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return acessorios;
	}

}
