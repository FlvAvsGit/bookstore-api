package com.udemy.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bookstore.domain.Categoria;
import com.udemy.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	public Categoria metodoFindService (Integer Id ) {
		Optional<Categoria> objeto = categoriaRepositorio.findById(Id);
		
		return objeto.orElse(null);
	}
}
