package com.nelionovais.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelionovais.cursomc.domain.Categoria;
import com.nelionovais.cursomc.domain.Produto;
import com.nelionovais.cursomc.repositories.CategoriaRepository;
import com.nelionovais.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat01 = new Categoria(null, "Informática");
		Categoria cat02 = new Categoria(null, "Escritório");
		
		Produto pro01 = new Produto(null, "Computador", 2000.00);
		Produto pro02 = new Produto(null, "Impressora", 800.00);
		Produto pro03 = new Produto(null, "Mouse", 80.00);
		
		cat01.getProdutos().addAll(Arrays.asList(pro01, pro02, pro03));
		cat02.getProdutos().addAll(Arrays.asList(pro02));
		
		pro01.getCategorias().addAll(Arrays.asList(cat01));
		pro02.getCategorias().addAll(Arrays.asList(cat01,cat02));
		pro03.getCategorias().addAll(Arrays.asList(cat02));
		
		
		categoriaRepository.save(Arrays.asList(cat01, cat02));
		produtoRepository.save(Arrays.asList(pro01, pro02, pro03));
		
	}
}
