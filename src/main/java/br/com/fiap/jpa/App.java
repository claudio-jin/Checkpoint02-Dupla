package br.com.fiap.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fiap.entity.Acessorio;
import br.com.fiap.entity.Carro;
import br.com.fiap.entity.Modelo;
import br.com.fiap.jpa.service.impl.AcessorioServiceImpl;
import br.com.fiap.jpa.service.impl.CarroServiceImpl;
import br.com.fiap.jpa.service.impl.ModeloServiceImpl;

public class App {

	public static void main(String[] args) {
		
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
		
		Acessorio acessorio = new Acessorio("Faróis Xenon");
		Acessorio acessorio2 = new Acessorio("Painel bluetooth");
		
		List<Acessorio> acessorios = new ArrayList<Acessorio>();
		acessorios.add(acessorio);
		acessorios.add(acessorio2);
		
		acessorioService.cadastrar(acessorio);
		acessorioService.cadastrar(acessorio2);
		
		
		Modelo modelo = new Modelo("Lamborghini");
		modeloService.cadastrar(modelo);
		
		
		Carro carro = new Carro("ABC123", "Preto", "Monobloco", acessorios ,modelo);
		
		
		carroService.cadastrar(carro);
//		
//		modeloService.cadastrar(modelo);

		carroService.listar().forEach(System.out::println);
		
	}
}
