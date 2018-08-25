package com.nelionovais.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelionovais.cursomc.domain.Categoria;
import com.nelionovais.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaServive {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		return obj;
	}
}
