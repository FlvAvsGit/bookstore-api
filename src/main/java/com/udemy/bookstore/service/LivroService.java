package com.udemy.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bookstore.domain.Livro;
import com.udemy.bookstore.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepositorio;
	
	public Livro metodoFindService (Integer Id ) {
		Optional<Livro> objLivro= livroRepositorio.findById(Id);
		
		return objLivro.orElse(null);
	}
	
	public List<Livro> metodoFindAllService () {
		 List<Livro> objLivro = livroRepositorio.findAll();
		return objLivro;
	}
	
}
