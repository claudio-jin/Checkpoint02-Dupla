package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.entity.Carro;
import br.com.fiap.jpa.dao.impl.CarroDaoImpl;
import br.com.fiap.jpa.service.GenericService;

public class CarroServiceImpl extends GenericService<Carro, Long>{

private static CarroServiceImpl instance = null;
	
	private CarroDaoImpl carroDao;
	
	private CarroServiceImpl() {
		carroDao = CarroDaoImpl.getInstance();
		
	}
	
	public static CarroServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		
		return instance;
	}
	
	
	
	@Override
	public void cadastrar(Carro carro) {
		try {
			carroDao.salvar(carro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	@Override
	public void atualizar(Carro carro) {
		try {
			carroDao.atualizar(carro, getEntityManager());
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
			carroDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}		
	}

	@Override
	public Carro obter(Long id) {
		Carro carro = null;
		
		try {
			carro = carroDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return carro;
	}

	@Override
	public List<Carro> listar() {
		List<Carro> carros = null;
		
		try {
			carros = carroDao.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return carros;
	}

}
